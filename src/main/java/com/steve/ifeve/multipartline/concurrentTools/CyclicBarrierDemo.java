package com.steve.ifeve.multipartline.concurrentTools;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: steve
 * @Date: Created in 9:45 2018/3/14
 * @Description: CyclicBarrier 使用示例。它和 CountDownLatch 的主要区别就是等待的线程是所有的线程，而CountDownLatch是主线程等待，其它线程还是可以执行的。
 *                 还有就是CyclicBarrier可以重置计数器
 * @Modified By:
 */
public class CyclicBarrierDemo {

    private void eatting(CyclicBarrier cyclicBarrier, Random random) {
        System.out.println(Thread.currentThread().getName() + "ready to eat");
        try {
            Thread.sleep(random.nextInt(2000));
            cyclicBarrier.await();
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getName() + " finally, I just can eat now.");
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        Random random = new Random();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("all member are rady to eat, Then just go to eat");
            }
        });
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i < 4; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    demo.eatting(cyclicBarrier,random);
                }
            });
        }
        executor.shutdown();
    }
}
