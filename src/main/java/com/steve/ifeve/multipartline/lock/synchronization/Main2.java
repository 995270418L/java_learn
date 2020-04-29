package com.steve.ifeve.multipartline.lock.synchronization;

import com.steve.ifeve.multipartline.lock.instance.MultiDemo;

public class Main2 {

    /**
     * Synchorized 的指令代码实现
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Main2 main = new Main2();
        main.testSingle();
    }

    public void testSingle() throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 9; i++) {
            threads[i] = new Thread(() -> {
                try {
                    MultiDemo.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (int i = 1; i <= 9; i++) {
            threads[i].join();
        }
    }


}
