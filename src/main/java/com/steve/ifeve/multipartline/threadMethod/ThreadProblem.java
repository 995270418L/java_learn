package com.steve.ifeve.multipartline.threadMethod;

/**
 * @Author: steve
 * @Date: Created in 22:43 2018/2/16
 * @Description: 线程安全性问题
 *  1: 多线程环境下
 *  2: 有共享资源
 *  3: 非原子性操作
 * @Modified By:
 */
public class ThreadProblem {

    private int value;

    public synchronized int getNext() throws InterruptedException {
        Thread.sleep(100);          // 不加这行很难出现脏数据现象。
        return value++;
    }
}
