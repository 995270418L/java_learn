package com.steve.ifeve.multipartline.chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liu on 6/16/17.
 * 使用显式条件变量的有界缓存
 */
public class ConditionBoundedBuffer<T> {

    protected final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final T[] items = (T[]) new Object[100];
    private int tail, head, count;

    //阻塞并直到: notFull
    public void put(T x) throws InterruptedException {
        lock.lock();
        try{
            while (count == items.length){
                notFull.await();
            }
            items[tail] = x;
            if(++tail == items.length){
                tail = 0;
            }
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    // 阻塞并直到: notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try{
            while(count == 0){
                notEmpty.await();
            }
            T x = items[head];
            items[head] = null;
            if( ++head == items.length){
                head = 0;
            }
            -- count;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }
}
