package com.steve.ifeve.JavaIo.Stream;

import java.io.*;

/**
 * Created by liu on 6/17/17.
 * 将数据返回值inputStream
 */
public class PushbackInputStreamDemo {

    /**
     * 使用场景: 只想读一读开头的数据。便使用pushbackInputStream将已经读取的数据放回原来的Stream.
     * @param args
     */
    public static void main(String... args) throws IOException {

        PushbackInputStream inputStream = new PushbackInputStream(new FileInputStream("/home/liu/Desktop/chinese.txt"));
        int data = inputStream.read();
        System.out.println(data);
        //push the read bytes back into the stream
        inputStream.unread(data);
        data = inputStream.read();
        System.out.println(data);

    }
}
