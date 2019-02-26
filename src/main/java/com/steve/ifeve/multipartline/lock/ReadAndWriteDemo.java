package com.steve.ifeve.multipartline.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: steve
 * @Date: Created in 11:20 2018/2/23
 * @Description: 读写锁使用实例
 *    读锁为共享锁，写锁为独占锁。
 *
 * @Modified By:
 */
public class ReadAndWriteDemo {

    private Map<String, String> map = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    /**
     * 读锁 方法
     * @param key
     * @return
     */
    public String get(String key){
        readLock.lock();
        System.out.println(Thread.currentThread().getName() +  "  读取锁开始 。。。。。。 ");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            return map.get(key);
        }  finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() +  "  读取锁结束 。。。。。。");
        }
    }

    /**
     * 写锁 方法
     * @param key
     * @param value
     */
    public void put(String key, String value){
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "  写入锁开始 。。。。。。 ");
        try{
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            map.put(key,value);
        }finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "  写入锁结束 。。。。。。 ");
        }
    }

    private boolean isUpdate = true;

    /**
     * 降级锁 方法
     * 由写锁降级为读锁
     */
    public String readWrite(String key,String value){
        readLock.lock(); // 加读锁，保证变量在线程间的一致性
        if(isUpdate){
            readLock.unlock();
            writeLock.lock();
            map.put(key,value);
            readLock.lock();
            writeLock.unlock();  // 在写锁释放前给读锁加锁
        }

        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }


    }

    public static void main(String[] args) {
        ReadAndWriteDemo demo = new ReadAndWriteDemo();
        readWriteDemo(demo);
    }

    public static void readWriteDemo(ReadAndWriteDemo demo){
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("steve1","liu");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.get("steve1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("steve2","liu");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.get("steve1");
            }
        }).start();
    }

    public static void readDemo(ReadAndWriteDemo demo){
        demo.put("steve1","liu");
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.get("steve1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.get("steve1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.get("steve1");
            }
        }).start();
    }
    /**
     * 写锁测试用例
     * @param demo
     */
    public static void writeDemo(ReadAndWriteDemo demo){
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("steve","liu");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("steve","liu");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("steve","liu");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("steve","liu");
            }
        }).start();
    }
}
