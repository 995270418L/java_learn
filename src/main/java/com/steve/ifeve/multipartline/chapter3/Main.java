package com.steve.ifeve.multipartline.chapter3;

/**
 * Created by liu on 5/4/17.
 */
public class Main {

    private static Holder holder;
    public static void main(String... args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                holder = new Holder(3);
                holder.assertSanity();
            }
        });
        thread1.start();
        holder = new Holder(4);

    }
}
