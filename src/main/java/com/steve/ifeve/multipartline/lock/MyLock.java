package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: steve
 * @Date: Created in 20:03 2018/2/21
 * @Description: 自定义实现锁(借助synchronized)
 * @Modified By:
 */
public class MyLock implements Lock {

    /**
     * 仅实现锁功能 的变量
     */
    private boolean isLocked = false;

    /**
     * 重入锁的实现，统计有多少锁数量发生了重入
     */
    private int lockCount = 0;

    /**
     * 重入锁的实现，记录当前线程
     */
    private Thread lockBy = null;

    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        if(isLocked && currentThread != lockBy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread;
        lockCount ++;
    }

    @Override
    public synchronized void unlock() {
        if(isLocked){
            if(lockBy == Thread.currentThread() && lockCount == 1) {
                notify();
                isLocked = false;
                lockBy = null;
            }
            lockCount --;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
