package com.steve.ifeve.multipartline.concurrentTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: steve
 * @Date: Created in 10:53 2018/3/14
 * @Description: Semaphore 使用示例，它能保证在并发访问过程中每次只能有固定的线程数访问某个资源
 * @Modified By:
 */
public class SemaphoreDemo {

    /**
     * 这里每次只有5个线程能同时访问
     * @param semaphore
     */
    private void demo(Semaphore semaphore){
        try {
            semaphore.acquire(); // 获取资源
            System.out.println(Thread.currentThread().getName() + " 开始执行1s的任务");
            Thread.sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        SemaphoreDemo demo = new SemaphoreDemo();
        ExecutorService exec = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    demo.demo(semaphore);
                }
            });
        }
        exec.shutdown();
        while(Thread.activeCount() != 2){}
        long end = System.currentTimeMillis();
        System.out.printf("任务执行完毕，共耗时: " + (end-start)); // 理论上是要多于10秒的，但切换的时间并不高，平均每3个线程间切换需要5ms。所以不会大于11秒。
    }
}
