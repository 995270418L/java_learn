package com.steve.ifeve.multipartline.chapter5.interfaces;

/**
 * 可重用的计算结果，缓存的实现。基于HashMap
 * @param <A>   输入条件
 * @param <V>   输出计算结果
 */
public interface Computable<A,V> {
    V compute(A args) throws InterruptedException;
}
