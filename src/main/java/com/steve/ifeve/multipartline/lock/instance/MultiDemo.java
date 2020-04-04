package com.steve.ifeve.multipartline.lock.instance;

public class MultiDemo {

    public static TestBean testBean = new TestBean(3);
    private static volatile MultiDemo multiDemo;

    private MultiDemo() {
    }

    public static MultiDemo getInstance() throws InterruptedException {
        if (multiDemo == null) {
            synchronized (MultiDemo.class) {  // 轻量级锁
                System.out.println("get this class thread: " + Thread.currentThread().getName());
                Thread.sleep(300);
                if (multiDemo == null) {
                    multiDemo = new MultiDemo();
                }
            }
        }
        return multiDemo;
    }

}
