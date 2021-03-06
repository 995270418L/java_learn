package com.steve.ifeve.multipartline.lock.synchronization;

import com.steve.algorithms.base.Pair;

/**
 * 这个示例需要验证的问题就是在方法上上锁会不会影响其他线程竞争其他方法
 */
public class Sync {

    public static int a = 3;
    public static int b = 100;

    public synchronized void setValue() {
        a = 5;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程: " + Thread.currentThread().getName() + "\t 执行完毕，其他线程可以开始了");
    }

    public void changeValue() {
        System.out.println("线程: " + Thread.currentThread().getName() + "\t 正在执行 Sync 类的changeValue 方法");
        a = 8;
    }

    public synchronized static void sync1() throws InterruptedException {
        a = 9;
        Thread.sleep(5000);
        System.out.println(a);
    }

    public void sync2() {
        a = 10;
        System.out.println(a);
    }

    public static void change(Pair<Integer, String> pair) throws InterruptedException {
        synchronized (pair) {
            System.out.println("thread coming : " + Thread.currentThread().getName() + "\t睡眠100ms");
            Thread.sleep(100);
            System.out.println(a++);
            System.out.println("using thread: " + Thread.currentThread().getName() + "\tKey: " + pair.getKey());
            System.out.println(b++);
//            System.out.println("pari value: " + pair.getValue());
        }
    }

}
