package com.steve.ifeve.multipartline.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: steve
 * @Date: Created in 17:12 2018/3/16
 * @Description: 生产者与消费者的中间商模型
 * @Modified By:
 */
public class Shop {

    // 当前库存量
    private int count = 1;

    // 生产者方法
//    public void push(Lock lock,Condition notFull,Condition notEmpty,int total){
//        lock.lock();
//        try{
//            while(count >= total){
//                System.out.println("库存已满，请消费者前来消费");
//                notEmpty.await();
//            }
//            System.out.println("生产者正在生产产品，当前库存量: " + ++count);
//            notFull.signal();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }

//    // 消费者方法
//    public void pop(Lock lock,Condition notFull,Condition notEmpty, int total){
//        lock.lock();
//        try{
//            while(count < 1){
//                System.out.println("库存为空，通知厂商生产。。。");
//                notFull.await();
//            }
//            count --;
//            System.out.println("消费者正在消费产品,库存剩余: " + count);
//            notEmpty.signal();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
}
