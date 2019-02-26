package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: steve
 * @Date: Created in 16:40 2018/3/16
 * @Description: 生产者和消费者模式
 * @Modified By:
 */
public class Product {

    /**
     * 当前库存量
     */
    private int total;

    private final Lock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public Product(int total,Lock lock,Condition notFull,Condition notEmpty){
        this.lock = lock;
        this.total = total;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
    }

    public void product(int[] count){
        lock.lock();
        try{
            while(count[0] >= total){
                System.out.println("库存已满，请消费者前来消费");
                notEmpty.await();
            }
            System.out.println("生产者正在生产产品，当前库存量: " + ++count[0]);
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
