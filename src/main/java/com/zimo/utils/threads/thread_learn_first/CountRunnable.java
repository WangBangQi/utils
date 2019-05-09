package com.zimo.utils.threads.thread_learn_first;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/8,4:16 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class CountRunnable implements Runnable {

    private static long num;

    @Override
    public void run() {
        for (int i=0;i<100000;i++) {
            ++num;
//            System.out.println("thread :" +Thread.currentThread()+" \tnum= "+num);
        }
    }

    public static long getNum() {
        return num;
    }
}
