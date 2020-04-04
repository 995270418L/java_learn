package com.steve.ifeve.multipartline.lock.instance;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            MultiDemo m = null;
            try {
                m = MultiDemo.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 " + m);
            MultiDemo.testBean.setA(5);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 " + m);
            System.out.println("t1 " + MultiDemo.testBean.getA());
        }, "t1");
        Thread t2 = new Thread(() -> {
            MultiDemo m = null;
            try {
                m = MultiDemo.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 " + m);
            MultiDemo.testBean.setA(6);
            System.out.println("t2 " + MultiDemo.testBean.getA());
        }, "t2");
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        System.out.println("over!");
    }
}
