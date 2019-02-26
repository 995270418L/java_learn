package com.steve.ifeve.multipartline.chapter11;


/**
 * Created by liu on 6/6/17.
 * 给予散列的Map实现。(锁分段技术的实现)
 */
public class StripedMap {
    private static final int N_LOCKS = 16;   // 最大的锁数量
    private final Node[] buckets;
    private final Object[] locks;            // 锁住的对象

    public StripedMap(int numBuckets){
        buckets = new Node[numBuckets];
        locks = new Object[N_LOCKS];
        for(int i=0; i< N_LOCKS; i++){
            locks[i] = new Object();
        }
    }

    /**
     * 散列方法
     * @param key
     * @return
     */
    private final int hash(Object key){
        return Math.abs(key.hashCode() % buckets.length);
    }

    /**
     * get 操作获得了1个锁。有可能造成死锁如果采用锁分段的话。(锁分解)
     * @param key
     * @return
     */
    public Object get(Object key){
        int hash = hash(key);
        synchronized(locks[hash % N_LOCKS]){
            for(Node m = buckets[hash]; m != null; m = m.next){
                if(m.key.equals(key)){
                    return m.value;
                }
            }
        }
        return null;
    }

    /**
     * clear操作获得了16个锁，因为并不需要同时获取16个线程的操作。（锁分段）
     *  在锁上竞争的频率高于在锁保护数据上发生竞争的频率。
     */
    public void clear(){
        for(int i=0; i<buckets.length; i++){
            synchronized (locks[i % N_LOCKS]) {
                buckets[i] = null;
            }
        }
    }

    /**
     * Node类
     */
    private static class Node{
        private Node next;
        private Node prev;
        private Node key;
        private Node value;
    }

}
