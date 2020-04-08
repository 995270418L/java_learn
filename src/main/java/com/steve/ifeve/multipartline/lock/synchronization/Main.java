package com.steve.ifeve.multipartline.lock.synchronization;

public class Main {

    /**
     * 同一个对象中，并发的时候多线程会不会并发访问对象中没加synchorized修饰符的方法 ？
     * 不会， 因为synchorized只会保护对象的指定代码块里面的代码不会并发访问。
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread[] thread = new Thread[10];
        Sync sync = new Sync();
        thread[0] = new Thread(() -> {
            try {
                Sync.sync1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        thread[0].start();
        for (int i = 1; i < 10; i++) {
            thread[i] = new Thread(() -> {
                sync.sync2();
            }, "t" + i);
            thread[i].start();
        }
    }

}
