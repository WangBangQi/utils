package com.zimo.utils.threads;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/3/25,9:24 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ThreadPoolExecutorLearn {

    private static int count = 0;

    public static void main(String args[])throws Exception{
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000000;i++){
                    count += 1;
                }
            }
        };


        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,1,0L
                , TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());

        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);

        //等待线程池中的所有任务完成
        threadPool.shutdown();
        while (!threadPool.awaitTermination(1L,TimeUnit.MILLISECONDS)){
            System.out.println("Not yet. Still waiting for termination");
        }

        System.out.println("count = "+count);
    }
}
