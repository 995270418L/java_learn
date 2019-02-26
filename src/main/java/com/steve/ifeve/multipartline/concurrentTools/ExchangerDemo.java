package com.steve.ifeve.multipartline.concurrentTools;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: steve
 * @Date: Created in 10:43 2018/3/14
 * @Description: exchanger 使用示例，使用限制: 只能是两个线程之间数据的比较。比较的过程中是线程安全的。
 * @Modified By:
 */
public class ExchangerDemo {

    /**
     * 使用Exchanger进行数据比较的两个方法
     * @param exch
     */
    private void a(Exchanger<Integer> exch){
        System.out.println(Thread.currentThread().getName() + " 的a方法正在执行抓取任务。。。");
        try {
            Thread.sleep(2500);
            Integer result = 12345;
            System.out.println(Thread.currentThread().getName() + " 的a方法抓取任务结束，结果为: " + result);
            // 这一方法会阻塞直到另一线程比较完毕。
            Integer res = exch.exchange(result);
            System.out.println("a方法两个线程的结果是否相等: " + res.equals(result));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void b(Exchanger<Integer> exch){
        System.out.println(Thread.currentThread().getName() + " 的b方法正在执行抓取任务。。。");
        try {
            Thread.sleep(2500);
            Integer result = 12344;
            System.out.println(Thread.currentThread().getName() + " 的b方法抓取任务结束，结果为: " + result);
            // 这一方法会阻塞直到另一线程比较完毕。
            Integer res = exch.exchange(result);
            System.out.println("b方法两个线程的结果是否相等: " + res.equals(result));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用Exchanger进行数据交换的例子
     * @param exchanger
     */
    private void c(Exchanger<List<String>> exchanger){
        List<String> list = new CopyOnWriteArrayList<String>(){
            {
                add("steve");
                add("steve1");
                add("steve2");
                add("steve3");
            }
        };
        System.out.println("c方法负责生产对象");
        try {
            Thread.sleep(1000);
            System.out.println("a 方法生产完毕");
            // 这个方法开始执行
            exchanger.exchange(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void d(Exchanger<List<String>> exchanger){
        List<String> list = null;
        System.out.println("d方法负责消费对象");
        try {
            Thread.sleep(2000);
            list = exchanger.exchange(list);
            System.out.println("d方法对象交换完毕。。。");
            list.stream().forEach(e -> System.out.print("d " + e + "  "));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        ExchangerDemo demo = new ExchangerDemo();
        Exchanger<Integer> exch = new Exchanger<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                demo.c(exchanger);
            }
        });
        exec.execute(new Runnable() {
            @Override
            public void run() {
                demo.d(exchanger);
            }
        });
//        exec.execute(new Runnable() {
//            @Override
//            public void run() {
//                demo.a(exch);
//            }
//        });
//        exec.execute(new Runnable() {
//            @Override
//            public void run() {
//                demo.b(exch);
//            }
//        });

        exec.shutdown();
    }
}
