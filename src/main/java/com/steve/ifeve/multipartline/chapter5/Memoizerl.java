package com.steve.ifeve.multipartline.chapter5;


import com.steve.ifeve.multipartline.chapter5.interfaces.Computable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 5/13/17.
 * 基于HashMap实现的缓存 第一种方法
 */
public class Memoizerl<A,V> implements Computable<A,V> {

    private final Map<A,V> cache = new HashMap<A, V>();

    private final Computable<A,V> com;

    public Memoizerl(Computable<A, V> com) {
        this.com = com;
    }

    /**
     * 这中每次只能有一个线程操作计算结果的方法效率地下，可能比ExpensiveFunction中的计算结果都慢
     * @param args
     * @return
     * @throws InterruptedException
     */
    @Override
    public  V compute(A args) throws InterruptedException {
        synchronized(this){
            V result = cache.get(args);
            if(result == null){
                result = com.compute(args);
                cache.put(args,result);
            }
            return result;
        }
    }
    /**
     * 第二种方法是使用ConcurrentHashMap替换HashMap以提供更好的并发访问性能
     */

    /**
     * 第三种方法使用FutureTask任务告知其他进程计算任务正在进行，请耐心等待并且不要那个同时再次进行计算。避免开销
     */
}
