package com.steve.ifeve.multipartline.chapter2;

/**
 * Created by liu on 4/23/17.
 */
class Widgit {
    public synchronized void doSomething(){
        System.out.println("Widgit dosomething");
    }
}

public class LoggingWidgit extends Widgit {

    public synchronized void doSomething(){
        System.out.println(getClass().getName() + " doSomething");
        super.doSomething();
    }

    public static void main(String... args){
        LoggingWidgit lw = new LoggingWidgit();
        lw.doSomething();
        lw.doSomething();
        /**
         *  线程切换消耗的速率果真挺大的呀！
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lw.doSomething();
                System.out.println("thread");
            }
        });
        thread.start();
        lw.doSomething();
    }
}
