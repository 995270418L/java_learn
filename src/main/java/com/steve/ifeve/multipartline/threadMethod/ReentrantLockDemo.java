package com.steve.ifeve.multipartline.threadMethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: steve
 * @Date: Created in 20:39 2018/3/14
 * @Description:
 * @Modified By:
 */
public class ReentrantLockDemo {

    private ReentrantLock lock = new ReentrantLock();

    private void a(){
        try {
            lock.lock();
            b();
            System.out.println("方法a");
        }finally {
            lock.unlock();
        }
    }
    private void b(){
        try {
            lock.lock();
            System.out.println("方法b");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();

    }
}
