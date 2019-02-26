package com.steve.ifeve.multipartline.chapter13;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liu on 6/16/17.
 * 用读 － 写　锁来包装　Map
 */
public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock r = lock.readLock();
    private final Lock w = lock.writeLock();

    public ReadWriteMap(Map<K, V> map){
        this.map = map;
    }

    public V put(K key, V value){
        w.lock();
        try{
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }

    public V get(K key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
}
