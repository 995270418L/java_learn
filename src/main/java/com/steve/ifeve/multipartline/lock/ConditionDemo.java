package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: steve
 * @Date: Created in 11:32 2018/3/15
 * @Description:
 * @Modified By:
 */
public class ConditionDemo {

    private int signal = 0;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    private void a(){
        try {
            lock.lock();
            while (signal != 0){
                try {
                    a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("a方法执行");
            signal ++ ;
            b.signal();
        }finally {
            lock.unlock();
        }
    }
    private void b(){
        try {
            lock.lock();
            while (signal != 1){
                try {
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("b方法执行");
            signal ++ ;
            c.signal();
        }finally {
            lock.unlock();
        }
    }
    private void c(){
        try {
            lock.lock();
            while (signal != 2){
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c方法执行");
            signal = 0 ;
            a.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    demo.c();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    demo.b();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    demo.a();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.shutdown();
    }
}
