package com.steve.ifeve.multipartline.foundation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: steve
 * @Date: Created in 16:12 2018/3/16
 * @Description: Future的使用
 * @Modified By:
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在计算结果...");
                Thread.sleep(3000);
                return 1;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask(callable);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("do something else");

        Integer result = futureTask.get();
        System.out.println("结果为: " + result);

    }
}
