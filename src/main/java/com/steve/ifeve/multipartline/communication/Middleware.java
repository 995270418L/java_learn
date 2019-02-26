package com.steve.ifeve.multipartline.communication;

import java.util.Collections;
import java.util.Vector;

/**
 * @Author: steve
 * @Date: Created in 13:27 2018/2/23
 * @Description: 生产者与消费者的中间商
 * @Modified By:
 */
public class Middleware {

    private int count;

    private final int MAX_VALUE = 10;

    public synchronized void set(){

        while (count >= MAX_VALUE){
            try{
                System.out.println("容量已达最大，生产者进入等待 。。。 ");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count ++;
        System.out.println(Thread.currentThread().getName() + "  正在生产，库存为 " + count);
        notifyAll();
    }

    public synchronized int get(){
        while(count <= 0){
            try{
                System.out.println("库存为空，消费者进行等待。。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count -- ;
        System.out.println( Thread.currentThread().getName() + " 正在消费，剩余的库存为 " + count );
        notifyAll();
        return count ;
    }
}
