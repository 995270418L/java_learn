package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: steve
 * @Date: Created in 13:05 2018/2/25
 * @Description:
 * @Modified By:
 */
public class SynchorizedDemo {

    private int value;
    private Lock lock = new ReentrantLock();

    public synchronized int getNext(){
        lock.lock();
        try {
            return value++;
        }finally {
            lock.unlock();
        }
    }

    public int getNext2(){
        Lock lock = new ReentrantLock();
        synchronized (this){
            return value ++;
        }
    }

}
