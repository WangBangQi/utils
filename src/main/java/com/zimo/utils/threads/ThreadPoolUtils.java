package com.zimo.utils.threads;

import cn.zimo.wbq.service.LogInterface;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/5,1:54 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ThreadPoolUtils {

    private static ThreadPoolExecutor threadPool = null;

    public static ThreadPoolExecutor getInstance(){
        if (threadPool == null){
            synchronized (ThreadPoolUtils.class){
                if (threadPool == null){
                    /**
                     *  corePoolSize: 最小的闲置的线程的个数
                     *  maximumPollSize: 允许创建的线程的最大的个数
                     *  keepAliveTime: 当线程池内的空闲线程超过corePoolSize的大小时，任务结束，该线程的最长保留时间
                     *  unit: the time unit for the keepAliveTime argument
                     *  workQueue: 记录任务的队列，该任务必须是实现 Runnable 方法.
                     */
                    threadPool = new ThreadPoolExecutor(1,1,0L
                            , TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
                }
            }
        }
        return threadPool;
    }

    public void addTask(Task task){
        threadPool.execute(task);
    }


    public static void main (String args[]){
//        ThreadPoolUtils.getInstance().execute(new Task());
//        ThreadPoolUtils.getInstance().execute(new Test());
        ArrayQueue<Integer> queue = new ArrayQueue<>(100);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100;i++) {
                    queue.put(new Random().nextInt());
                }
            }
        });
        ThreadPoolUtils.getInstance().execute(thread);
        ThreadPoolUtils.getInstance().execute(thread);
        ThreadPoolUtils.getInstance().execute(thread);

        int size=0;
        while (true){
            size++;
            System.out.println("size="+size+"  数组大小为:"+queue.size()+" : "+queue.get());
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
    }
}
