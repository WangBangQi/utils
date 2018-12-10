package cn.zimo.wbq.delayedQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedEvent implements Delayed {
    //要执行的任务
    private Task task;
    private String uniqueKey; //该uniqueKey的生成规则根据业务来进行确定。只需要确保uniqueKey是唯一标识的
    private Long endTime;

    /**
     *
     * @param task
     * @param endTime
     * @param targetClassId 标志唯一
     */
    public DelayedEvent(Task task, Long endTime, String targetClassId) {
        this.task = task;
        this.endTime = endTime;
        setUniqueKey(targetClassId);
        System.out.println("unique key : "+getUniqueKey());
    }

    //获取剩余的时间，为0获取负数时取出
    //TimeUnit.NANOSECONDS 毫微妙
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(endTime,TimeUnit.NANOSECONDS) - unit.convert(System.currentTimeMillis(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this == o)
            return 1;
        if (o==null)
            return -1;
        long diff = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff<0?-1:(diff==0?0:1);
    }

    @Override
    public int hashCode() {
        final int prime = 31; //hashCode就是用的31
        int result = 1;
        result = prime*result + endTime.hashCode();
        result = prime*result + ((uniqueKey==null)?0:uniqueKey.hashCode());
        //我这里因为Task也是一个对象，为了简便，所以不用task作为hashCode生成对象。而是新增加一个uniqueKey。
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj == null)
            return false;
        if (getClass()!=obj.getClass())
            return false;
        DelayedEvent o = (DelayedEvent)obj;
        //Long对象的比较，判断值是否相同也是通过equals
        if (!getEndTime().equals(o.getEndTime()))
            return false;
        if (!getUniqueKey().equals(o.getUniqueKey()))
            return false;
        return true;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String targetClassId) {
        //uniqueKey生成规则
        this.uniqueKey = new StringBuffer().append(task.getClass()).append(targetClassId).append(endTime).toString();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
