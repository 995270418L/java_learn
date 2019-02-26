package com.steve.ifeve.JavaIo.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by liu on 6/17/17.
 * 管道　即　两个线程间互相通信的基础
 */
public class PipeExample {

    public static void main(String... args) throws IOException {
        // 这里是通过构造参数赋值的方法设值进入　也可以通过connect()　方法设值进入。
        final PipedInputStream inputStream = new PipedInputStream();
        final PipedOutputStream outputStream = new PipedOutputStream();
        inputStream.connect(outputStream); // 反过来调用也行

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    outputStream.write("hello pipes ".getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = inputStream.read();
                    while(data != -1){
                        System.out.print(data+" ");
                        data = inputStream.read();
                    }
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
