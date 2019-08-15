package cn.zimo.wbq.delayedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component("delayedService")
public class DelayedServiceImpl implements DelayedService {
    private static final Logger logger = LoggerFactory.getLogger(DelayedServiceImpl.class);
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DelayQueue<DelayedEvent> queue = new DelayQueue<>();
    private Executor executor = Executors.newFixedThreadPool(30);//线程池,保证同一时刻执行的任务能执行s
    private Thread damon;//守护线程

    @Override
    public void init(){
        logger.info("初始化任务调度线程");
        damon = new Thread(() -> execute()); //新建一个线程，执行execute方法
        damon.setDaemon(true);  //设置为守护线程
        damon.setName("delayed queue thread");  //线程名称
        damon.start();  //启动线程
    }

    @Override
    public void put(DelayedEvent delayed){
        logger.info("插入任务,任务执行时间为:{}",TIME_FORMAT.format(delayed.getEndTime()));
        queue.put(delayed);
    }

    @Override
    public boolean remove(DelayedEvent delayed){
        logger.info("移除任务,此时的时间为：{}",TIME_FORMAT.format(new Date()));
        return queue.remove(delayed);
    }

    private void execute(){
        while (true){
            //该线程要执行的内容
            try {
                DelayedEvent delayed = queue.take();
                if (delayed!=null){
                    logger.info("执行任务,任务执行时当前时间是 {}",TIME_FORMAT.format(delayed.getEndTime()));
                    executor.execute(new Runnable() {
                        //将执行的任务放入线程池，同一个时刻可能有多个任务要执行
                        @Override
                        public void run() {
                            delayed.getTask().executeTask();//执行任务
                        }
                    });
                }
            }catch (InterruptedException e){
                logger.error("任务调度被中断",e);
            }
        }
    }
}
