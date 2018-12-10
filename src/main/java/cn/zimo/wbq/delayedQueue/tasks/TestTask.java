package cn.zimo.wbq.delayedQueue.tasks;

import cn.zimo.wbq.delayedQueue.Task;

public class TestTask implements Task {

    @Override
    public void executeTask() {
        System.out.println("任务调度测试任务");
    }
}
