package com.steve.ifeve.multipartline.chapter12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by liu on 6/7/17.
 * java的信号量测试 Semaphore
 */
public class Main {

    public static void main(String... args){

        /**
         * 只能有5个坑
         */
        final Semaphore s =new Semaphore(5);

        /**
         * 线程池
         */
        final ExecutorService ex = Executors.newCachedThreadPool();

        for(int i=0;i< 20;i++){
            int NO = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取访问线程许可
                        s.acquire();
                        System.out.println("Access: " + NO);
                        Thread.sleep(1000);
                        // 访问完后 释放
                        s.release();
                        // 打印出可用的许可
                        System.out.println("--------------------" + s.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            ex.execute(run);
        }
        //关闭线程池
        ex.shutdown();
    }
}
