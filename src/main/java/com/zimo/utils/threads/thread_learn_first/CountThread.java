package com.zimo.utils.threads.thread_learn_first;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/8,4:07 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class CountThread extends Thread{

    private static volatile long num;

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            ++num;
            System.out.println("thread :" +Thread.currentThread()+" \tnum= "+num);
        }
    }

    public static long getNum() {
        return num;
    }
}
