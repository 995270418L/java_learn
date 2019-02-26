package com.steve.ifeve.multipartline.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liu on 5/6/17.
 * 客户端加锁 都会破坏同步策略的封装性。
 */
public class BetterList<E> {

    private List<E> list =
            Collections.synchronizedList(new ArrayList<E>());

    /**
     * 这里就不能通过在方法级别上加锁来实现原子性操作了，
     * @param x
     * @return
     */
    public boolean putIfAbsent(E x){
        synchronized(list){
            boolean absent = !list.contains(x);
            if(absent){
                list.add(x);
            }
            return absent;
        }
    }
}
