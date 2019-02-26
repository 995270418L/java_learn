package com.steve.ifeve.multipartline.chapter4;

import java.util.Vector;

/**
 * Created by liu on 5/6/17.
 * Vector类的安全扩展类
 */
public class BetterVector<E> extends Vector<E> {

    /**
     * 没有则添加 如果这个加锁策略和父类不同的话就会破坏同步策略，子类也就不是线程安全的类了
     * @param x  待添加元素
     * @return
     */
    public synchronized boolean putIfAbsent(E x){

        boolean absent = !contains(x);

        if(absent){
            add(x);
        }

        return absent;
    }

}
