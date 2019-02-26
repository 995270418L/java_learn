package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: steve
 * @Date: Created in 16:58 2018/3/16
 * @Description:
 * @Modified By:
 */
public class PCMain {

    private static final int TOTAL = 10;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        Product p = new Product(TOTAL,lock,notFull,notEmpty);
        Consumer c = new Consumer(lock,notFull,notEmpty);
        int[] a = {1};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i< 5 ;i ++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        p.product(a);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        for(int i = 0;i< 5 ;i ++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        c.consumer(a);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
