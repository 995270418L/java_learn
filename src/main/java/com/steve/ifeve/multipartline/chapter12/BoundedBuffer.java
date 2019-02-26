package com.steve.ifeve.multipartline.chapter12;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.Semaphore;

/**
 * Created by liu on 6/7/17.
 * 并发程序的测试
 * 基于信号量(Semaphore)的有界缓存
 */
@ThreadSafe
public class BoundedBuffer<E> {

    private final Semaphore availableItems, availableSpaces;
    @GuardedBy("this") private final E[] items;
    @GuardedBy("this") private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity){
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return availableItems.availablePermits() == 0;  // 可用的项目的许可是否为0,若为0,没有可用的项目。
    }

    public boolean isFull(){
        return availableSpaces.availablePermits() == 0;  // 可用的空间的许可是否为0,若为0,则没有可用的空间。
    }

    /**
     * put 操作，首先需要获取availableSpace的许可，再看是否满了
     * put 和 take 操作都保证了有界队列的大小总和保持不变
     * @param x
     */
    public void put(E x) throws InterruptedException {
        /**
         * 可用的空间 - 1
         */
        availableSpaces.acquire();  // 获取permit
        doInsert(x);
        /**
         * 为可用的项目增加一个空位
         */
        availableItems.release();   // 释放permit
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : 1;   //初始化了一个items数组，items数组有长度吗？
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : 1;
        return x;
    }
}
