package com.steve.ifeve.multipartline.foundation;

/**
 * @Author: steve
 * @Date: Created in 19:00 2018/3/9
 * @Description: synchorized 的用法。非静态方法为类实例，静态方法是当前类。
 * @Modified By:
 */
public class SynchorizedDemo {

    private static int i;
    static class DemoThread implements Runnable {
        /**
         * 这里锁住的是当前的类实例
         */
        private static synchronized void increase() {
            i++;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                increase();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThread());
        Thread t2 = new Thread(new DemoThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
