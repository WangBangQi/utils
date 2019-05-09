package com.zimo.utils.threads.thread_learn_first;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

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


        int threadNumber = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        for (int i=0;i<threadNumber;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10000;i++)
                        num++;
                    System.out.println(Thread.currentThread() +" \t finished!" );
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread()+" \t"+num);

    }
}
