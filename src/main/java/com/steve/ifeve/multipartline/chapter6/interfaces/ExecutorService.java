package com.steve.ifeve.multipartline.chapter6.interfaces;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liu on 5/13/17.
 * 任务调度服务
 */
public interface ExecutorService extends Executor {

    void shutdown();   //等待任务执行关闭
    List<Runnable> shutdownNow();  //直接关闭方法
    boolean isShutdown();      //观察这个执行器是否shut down
    boolean isTerminated();      //观察所有的任务是否shut down
    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

}
