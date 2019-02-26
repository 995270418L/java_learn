package com.steve.ifeve.multipartline.chapter1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liu on 4/9/17.
 * 死锁示例
 */
public class DeadLockDemo {

    private static final String A = "A";
    private static final String B = "B";

    public static void main(String... args){
        new DeadLockDemo().deadLock();
        AtomicInteger atomicInteger = new AtomicInteger(0);
    }

    private void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(A) {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){
                        System.out.print("1");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B){
                    synchronized(A){
                        System.out.println("2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
