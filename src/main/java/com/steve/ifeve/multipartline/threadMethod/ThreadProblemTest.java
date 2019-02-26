package com.steve.ifeve.multipartline.threadMethod;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: steve
 * @Date: Created in 22:45 2018/2/16
 * @Description:
 * @Modified By:
 */
public class ThreadProblemTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService =  Executors.newFixedThreadPool(10);

        SingletonHungry threadProblem = SingletonHungry.getSingletonHungry();

        SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
        for(int i=0;i<100;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : " + singletonLazy);
                }
            });
        }
        executorService.shutdown();
    }
}
