package com.steve.ifeve.multipartline.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liu on 5/9/17.
 *　在计时测试中使用CountDownLatch来启动和停止线程
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {

        //每个CountDownLatch中都有一个计数器.当计数器为０时，开启门(通道)
        //启动门
        final CountDownLatch startGate = new CountDownLatch(1);
        //结束门
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for(int i=0;i<nThreads;i++){
            Thread t = new Thread(){
                public void run(){
                    try {
                        //当计数器不为０的时候 await会一直阻塞
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            //调用countDown方法降低计数器 (表示一个事件已经发生)
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }


}
