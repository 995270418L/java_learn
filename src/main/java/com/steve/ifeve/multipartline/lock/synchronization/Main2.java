package com.steve.ifeve.multipartline.lock.synchronization;

import org.openjdk.jol.info.ClassLayout;

public class Main2 {

    /**
     * Synchorized 的指令代码实现
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        synchronized (o) {   // 轻量级锁
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
