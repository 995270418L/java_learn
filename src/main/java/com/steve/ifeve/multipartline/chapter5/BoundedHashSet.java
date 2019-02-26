package com.steve.ifeve.multipartline.chapter5;

import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by liu on 5/13/17.
 * 使用Semaphore将set变为有限边界
 */
public class BoundedHashSet<T> {

    private final Set<T> set;
    /**
     * 一个带有阻塞的信号量，用来控制资源的访问和删除
     * add方法前哦按段资源池中是否已满。
     * remove 方法前判断资源池中是否为空。
     * 阻塞
     * 阻塞操作是通过acquire方法来实现的
     */
    private final Semaphore sem;

    public BoundedHashSet(Set<T> set, Semaphore sem) {
        this.set = set;
        this.sem = sem;
    }

    //add 方法
    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o); //判断添加是否成功
            return wasAdded;
        }finally{
            if(!wasAdded)
                sem.release();   //添加失败的话通知semaphore释放许可信号量
        }
    }

    //remove方法
    public boolean remove(Object o){
        boolean wasRemoved = set.remove(o);
        if(wasRemoved)
            sem.release();
        return wasRemoved;
    }
}
