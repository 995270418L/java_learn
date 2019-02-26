package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: steve
 * @Date: Created in 16:46 2018/3/16
 * @Description: 消费者生产者模式
 * @Modified By:
 */
public class Consumer {

    private final Lock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public Consumer(Lock lock, Condition notFull, Condition notEmpty){
        this.lock = lock;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
    }

    public void consumer(int[] count){
        lock.lock();
        try{
            while(count[0] < 1){
                System.out.println("库存为空，通知厂商生产。。。");
                notFull.await();
            }
            count[0] --;
            System.out.println("消费者正在消费产品,库存剩余: " + count[0]);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
