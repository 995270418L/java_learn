package com.steve.ifeve.multipartline.lock.synchronization;

import org.openjdk.jol.info.ClassLayout;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Native o = new Native();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        synchronized (o) {   // 清量级锁
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
    }

    static class Native {

    }

}
