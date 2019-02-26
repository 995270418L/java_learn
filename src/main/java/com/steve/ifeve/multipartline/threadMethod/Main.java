package com.steve.ifeve.multipartline.threadMethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Author: steve
 * @Date: Created in 13:33 2018/2/13
 * @Description: 线程的9种创建方式
 * @Modified By:
 */
@Configuration
@ComponentScan()
@EnableAsync
public class Main {

    /**
     * 继承Thread类重些run方法来实现新线程
     */
    static class Demo1 extends Thread{
        @Override
        public void run() {
            System.out.println("Thread change run implements running ....");
        }
    }

    /**
     * 实现Runnable接口来实现新线程的创建
     */
    static class Demo2 implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runnable implements method ... ");
        }

    }

    static class Demo3 implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("返回值的方式创建线程");
            Thread.sleep(3000);
            System.out.println("返回值的方式创建线程");
            return 1;
        }

    }

    @Service
    class Demo4{

        @Async
        public void printA() throws InterruptedException {
            while(true) {
                Thread.sleep(300);
                System.out.println("a");
            }
        }

        @Async
        public void printB() throws InterruptedException {
            while(true) {
                Thread.sleep(300);
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1
        Demo1 demo1 = new Demo1();
        demo1.run();

        // 2
        Thread thread = new Thread(new Demo2());
        thread.start();

        // 3
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Demo3());
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        System.out.println("结束了吗?");
        System.out.println("计算的结果: " + futureTask.get());

        // 4 匿名内部类
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的方式创建线程！！！");
            }
        });
        thread2.start();

        // 5
        Thread thread3 = new Thread(){
            @Override
            public void run() {
                System.out.println("重写run方法");
            }
        };
        thread3.start();

        // 6 Spring实现多线程技术
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        Demo4 threadService = applicationContext.getBean(Demo4.class);
        threadService.printA();
        threadService.printB();

        // 7 lambda 方式实现多线程技术
        List<Integer> lists = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        lists.parallelStream().forEach(System.out :: println);

        // 8 线程池的实现方法
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 这里可以有多种不同的实现选择
        for(int i=0; i<100; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        // 9 定时器实现多线程
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器的多线程");
            }
        },1000,3000);

    }
}
