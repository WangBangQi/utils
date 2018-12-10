package cn.zimo.wbq.delayedQueue;

public interface DelayedService {
    //插入任务调度
     void put(DelayedEvent delayed);
     //移除任务调度
     boolean remove(DelayedEvent delayed);
     //初始化该任务调度
     void init();
}
