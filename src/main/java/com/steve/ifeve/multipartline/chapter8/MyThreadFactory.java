package com.steve.ifeve.multipartline.chapter8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Created by liu on 5/21/17.
 * 自定义线程池
 */
public class MyThreadFactory extends Thread {

    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable r){
        return new MyAppThread(r,poolName);
    }

    static class MyAppThread extends Thread{

        private static final String DEFAULT_NAME = "myAppThread";
        private static volatile boolean debugLifeStyle = false;
        private static final AtomicInteger created = new AtomicInteger();
        private static final AtomicInteger alive = new AtomicInteger();
        private static final Logger logger = Logger.getAnonymousLogger();

        public MyAppThread(Runnable r){
            this(r, DEFAULT_NAME);
        }

        public MyAppThread(Runnable r, String poolName) {
            super(r,poolName+"-" + created.incrementAndGet());
            setUncaughtExceptionHandler(new UncaughtExceptionHandler(){

                @Override
                public void uncaughtException(Thread t, Throwable e) {

                }
            });
        }
        public void run(){

        }
    }

}
