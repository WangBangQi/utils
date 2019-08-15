package com.zimo.utils.threads;

import java.util.concurrent.*;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/10,1:52 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class CallableAndFuture {

    static class MyThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello world";
        }
    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {

        }
    }

    static class MyThread3 implements Callable<String>{
        @Override
        public String call() throws Exception {

            Thread.sleep(1200);

            return "Hello World 3";
        }
    }


    public static void main(String args[]){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<String> future = threadPool.submit(new MyThread());
        Future<String> future3 = threadPool.submit(new MyThread3());
        try {
            System.out.println(future.get());
//            System.out.println(future3.get(5000L,TimeUnit.NANOSECONDS)==null?"is null":"have value");
            System.out.println(future3.get(3,TimeUnit.SECONDS));
            System.out.println("finished!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
