package com.steve.ifeve.multipartline.chapter7;

import java.util.concurrent.TimeUnit;

/**
 * Created by liu on 5/17/17.
 * 在专门的线程中中断任务
 */
public class aSecondOfPrimes {
    public static void timedRun(final Runnable r, long timeout, TimeUnit unit){
        class RethrowableTask implements Runnable{
            private volatile Throwable t;
            @Override
            public void run() {
                try {
                    r.run();
                }catch(Throwable t){
                    this.t = t;
                }
            }
            void rethrow() throws Throwable {
                if( t != null ){
                    throw t;
                }
            }
        }
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();

    }
}
