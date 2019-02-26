package com.steve.ifeve.multipartline.threadMethod;

/**
 * @Author: steve
 * @Date: Created in 12:58 2018/2/20
 * @Description: 锁的重入
 * @Modified By:
 */
public class ThreadReentrant {

    /**
     * synchronized 标志的方法锁住的是当前的类实例
     */
    public synchronized  void a(){
        System.out.println("a ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b();
    }

    public synchronized  void b() {
        System.out.println("b ... ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程开始 。。。 ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程结束 。。。 ");
        }).start();

        while(Thread.activeCount() != 2){

        }
        System.out.println("over 。。。");
    }

}
