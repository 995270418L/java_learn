package com.steve.ifeve.multipartline.chapter9;

import java.util.concurrent.*;

/**
 * Created by liu on 5/25/17.
 * 使用那个Executor实现SwingUtilities( isEventDispatchThread(判断当前线程是否是事件线程)
 *                                   invokeLater(将一个Runnable任务调度到事件线程中执行)
 *                                   invokeAndWait (将一个Runnable任务调度到事件线程中执行，并阻塞当前线程直到任务完成。))
 */
public class SwingUtilities {

    private static final ExecutorService exec = Executors.newSingleThreadExecutor(new SwingThreadFactory());
    private static volatile Thread swingThread;

    private static class SwingThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            swingThread = new Thread(r);
            return swingThread;
        }
    }

    public static boolean isEventDispatchThread(){
        return Thread.currentThread() == swingThread;
    }

    public static void invokeLater(Runnable r){
        exec.execute(r);
    }

    public static void invokeAndWait(Runnable task) throws InterruptedException {
        Future f = exec.submit(task);
        try{
            f.get();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
