package com.steve.ifeve.multipartline.chapter3;

/**
 * Created by liu on 5/4/17.
 * 变量可见性
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready)
                //下一个线程
                Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String... args){
        new ReaderThread().start();
        number = 2;
        ready = true;
    }
}
