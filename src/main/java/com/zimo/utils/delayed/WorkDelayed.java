package com.zimo.utils.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 子墨
 *
 */
public class WorkDelayed implements Delayed {

    private final long origin;
    private final long delay;
    private final WorkItem workItem; //工作项目

    public WorkDelayed(long delay, WorkItem workItem) {
        this.origin = System.currentTimeMillis();
        this.delay = delay;
        this.workItem = workItem;
    }

    /**
     * 获取剩余的延迟时间。
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay - (System.currentTimeMillis() - origin),TimeUnit.MILLISECONDS);
    }

    /**
     * 比较，用于插入队列中。
     * @param delayed
     * @return
     */
    @Override
    public int compareTo(Delayed delayed) {
        if (delayed == this){
            return 0;
        }
        if (delayed instanceof WorkDelayed){
            long diff = delay - ((WorkDelayed)delayed).delay;
            return (diff==0)?0:((diff<0)?-1:1);
        }
        long diff = getDelay(TimeUnit.MILLISECONDS) - delayed.getDelay(TimeUnit.MILLISECONDS);
        return (diff==0)?0:((diff<0)?-1:1);
    }



    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
