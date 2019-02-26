package com.steve.ifeve.multipartline.chapter8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Created by liu on 5/20/17.
 * 无界队列和使用Semaphore(信号量)来限制任务到达速率。设置信号量的上限为线程池的大小加上可排队任务数量
 */
public class BoundExecutor {
    private final Executor exec;
    private final Semaphore semaphore;

    public BoundExecutor(Executor exec, Semaphore semaphore) {
        this.exec = exec;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire(); //获取可用的信号量
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }catch(RejectedExecutionException e){
            semaphore.release();
        }
    }
}
