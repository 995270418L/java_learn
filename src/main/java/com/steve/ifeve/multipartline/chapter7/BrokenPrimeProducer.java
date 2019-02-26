package com.steve.ifeve.multipartline.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liu on 5/16/17.
 * 不可靠的取消操作(calcelled变量取消)将把生产者置于阻塞的操作中(不要这么做)
 */
public class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run(){
        try{
            BigInteger p= BigInteger.ONE;
            while(!cancelled){
                //阻塞方式的put操作,当队列已满的时候，消费者线程调用cancel方法，而put方法一直等待消费者消费，所以不会去检查cancelled的状态.永远不会结束。
                queue.put(p = p.nextProbablePrime());// 解决这个问题可以通过中断来解决
            }
//            while(!Thread.currentThread().isInterrupted()){
//                queue.put(p = p.nextProbablePrime());
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        cancelled = true;
    }
}
