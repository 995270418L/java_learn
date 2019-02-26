package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.locks.Lock;

/**
 * @Author: steve
 * @Date: Created in 18:11 2018/2/22
 * @Description:
 * @Modified By:
 */
public class Main {

    private int value = 0;

    private Lock lock = new MyLock();

    private int getNext(){
        lock.lock();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return value++;
        }finally {
            lock.unlock();
        }
    }

    private void a(){
        lock.lock();
        try {
            System.out.println("a start ...");
            b();
            System.out.println("a end ... ");
        }finally {
            lock.unlock();
        }
    }

    private void b(){
        lock.lock();
        try {
            System.out.println("b start ...");
            System.out.println("b end ... ");
        }finally {
            lock.unlock();
        }
    }

//    public static void main(String[] args) {
//        Main main = new Main();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i< 100; i ++){
//                    System.out.println(Thread.currentThread().getName() + " " + main.getNext());
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i< 100; i ++){
//                    System.out.println(Thread.currentThread().getName() + " " + main.getNext());
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i< 100; i ++){
//                    System.out.println(Thread.currentThread().getName() + " " + main.getNext());
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i< 100; i ++){
//                    System.out.println(Thread.currentThread().getName() + " " + main.getNext());
//                }
//            }
//        }).start();
//    }
    public static void main(String[] args) {
        Main main = new Main();
        new Thread(new Runnable() {
            @Override
            public void run() {
                main.a();
            }
        }).start();
    }
}
