package com.zimo.utils.threads.thread_learn_first;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/8,4:09 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ThreadTest {

    static volatile long num;

    public static void main(String args[])throws Exception{
        CountThread thread = new CountThread();
        thread.start();
        CountThread thread2 = new CountThread();
        thread2.start();
        Thread.sleep(10);
        System.out.println(CountThread.getNum());

        ReentrantLock lock = new ReentrantLock();

        int threadNumber = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        for (int i=0;i<threadNumber;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int i=0;i<10;i++)
                            num++;
                        System.out.println(Thread.currentThread() +" \t finished!" );
                        countDownLatch.countDown();
                    }finally {
                        lock.unlock();
                    }

                }
            }).start();
        }
        countDownLatch.await();
//        while (Thread.activeCount() > 0)
            System.out.println(Thread.currentThread()+" \t"+num);

    }
}
