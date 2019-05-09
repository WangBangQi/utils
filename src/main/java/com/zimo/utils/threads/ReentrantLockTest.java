package com.zimo.utils.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/6,11:44 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ReentrantLockTest{

    public static volatile int count = 0;

    public static void main(String args[])throws InterruptedException{
        final ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() ->{
            for (int i=0;i<10000000;i++) {
                try {
                    lock.lockInterruptibly();
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() ->{
            for (int i=0;i<10000000;i++) {
                try {
                    lock.lockInterruptibly();
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        System.out.println(count);
    }
}
