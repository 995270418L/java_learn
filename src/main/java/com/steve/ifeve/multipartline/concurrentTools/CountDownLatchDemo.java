package com.steve.ifeve.multipartline.concurrentTools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: steve
 * @Date: Created in 9:20 2018/3/14
 * @Description: CountDownLatch 使用示例
 * @Modified By:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CountDownLatchDemo demo = new CountDownLatchDemo();
        long start = System.currentTimeMillis();
        for(int i=0; i< 3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.execute(countDownLatch);
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("所有线程准备完毕，准备时间: " + (end-start) + " 开始执行下一段任务。" );
    }
    public void execute(CountDownLatch countDownLatch){
        System.out.println(Thread.currentThread().getName() + "执行2秒任务");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + " 线程 执行完毕，返回主线程执行");
        AtomicInteger a = new AtomicInteger(0);
    }
}
