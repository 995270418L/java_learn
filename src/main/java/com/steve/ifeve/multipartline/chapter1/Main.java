package com.steve.ifeve.multipartline.chapter1;

/**
 * Created by liu on 4/9/17.
 * 并发一定比单线程快吗?
 */
public class Main {

    private static final long count = 1000000;

    public static void main(String... args) throws InterruptedException {
        concurrency();
        serial();
    }

    //并发性，同时
    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(int i=0;i<count ;i++){
                    a ++;
                }
            }
        });
        thread.start();
        int b=0;
        for(int i=0;i<count;i++){
            b--;
        }
        long end = System.currentTimeMillis();
        thread.join();   // 等待线程死亡
        System.out.println("concurrency:" + (end-start) + "ms");
    }

    //连续的(单线程)
    public static void serial(){
        long start = System.currentTimeMillis();
        int a=0,b=0;
        for(int i=0;i<count;i++){
            a ++ ;
        }
        for(int i=0;i<count;i++){
            b --;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+ "ms");
    }
}

/**
 * 当并发执行累加操作不超过百万次时,速度会比串行执行累加操作要
 * 慢。那么,为什么并发执行的速度会比串行慢呢?这是因为线程有创建和上下文切换的开销
 */
