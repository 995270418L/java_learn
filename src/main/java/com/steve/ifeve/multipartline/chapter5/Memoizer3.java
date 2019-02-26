package com.steve.ifeve.multipartline.chapter5;

import com.steve.ifeve.multipartline.chapter5.interfaces.Computable;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by liu on 5/13/17.
 * 依然使用ConcurrentHashMap来提高并发性能(它并不是一个线程安全类)
 */
public class Memoizer3<A,V> implements Computable<A,V> {

    private final Computable<A,V> c;
    private final Map<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final ConcurrentMap<A,Future<V>> cache2 = new ConcurrentHashMap<A, Future<V>>();

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * 使用FutureTask可以告知其他线程这正在计算，请耐心等待
     * @param args
     * @return
     * @throws InterruptedException
     */
    @Override
    public V compute(A args) throws InterruptedException {
        Future<V> result = cache2.get(args);
        if(result == null){
            //构建FutureTask的参数Callrable　回调函数，调用run方法时执行
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(args);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(callable);
            result = ft;
            /**
             * 这里的put操作底层实现是基于Map的，这个对象无法通过加锁来确保原子性操作，所以会存在多次计算的可能性.
             * 优化方法是使用ConcurrentMap来替代Map对象,使用他的putIfAbsent方法替代put方法。
             */
            cache.put(args,result);
            ft.run(); // 开始执行计算
        }
        V value = null;
        try {
            value =  result.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return value;
    }
}
