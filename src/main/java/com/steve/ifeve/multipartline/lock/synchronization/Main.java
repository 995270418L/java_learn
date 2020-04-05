package com.steve.ifeve.multipartline.lock.synchronization;

public class Main {

    public static void main(String[] args) {
        Thread[] thread = new Thread[10];
        Sync sync = new Sync();
        thread[0] = new Thread(() -> {
            sync.setValue();
            System.out.println(Sync.a);
        }, "t1");
        thread[0].start();
        for (int i = 1; i < 10; i++) {
            thread[i] = new Thread(() -> {
                sync.changeValue();
                System.out.println(Sync.a);
            }, "t" + i);
            thread[i].start();
        }
    }

}
