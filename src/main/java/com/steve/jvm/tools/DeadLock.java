package com.steve.jvm.tools;

/**
 * @Author: steve
 * @Date: Created in 19:35 2018/2/6
 * @Description:
 * @Modified By:
 */
public class DeadLock implements Runnable {
    private Object obj1;
    private Object obj2;

    public DeadLock(Object obj1,Object obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1){
            try {
                // 不休息这100ms，难以重现死锁，因为jvm执行太快了。
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println("You can't see this message, Beaucase of DeadLock !!");
            }
        }
    }
}
