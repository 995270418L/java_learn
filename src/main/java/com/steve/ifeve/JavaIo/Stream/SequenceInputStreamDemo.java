package com.steve.ifeve.JavaIo.Stream;

import java.io.*;

/**
 * Created by liu on 6/17/17.
 * 将多个inputStream流串在一起的流
 */
public class SequenceInputStreamDemo {

    private static final String FILEPATH1 = "/home/liu/Desktop/chinese.txt";
    private static final String FILEPATH2 = "/home/liu/Desktop/java.jpg";

    public static void main(String... args) throws IOException {
        InputStream inputStream = new FileInputStream(FILEPATH1);
        InputStream inputStream1 = new FileInputStream(FILEPATH2);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1,inputStream1);

        /**
         * 先读取第一个流里面的数据，再读取第二个
         */
        int data = sequenceInputStream.read();
        while(data != -1){
            System.out.println(data + " ");
            data = sequenceInputStream.read();
        }
        sequenceInputStream.close();
        inputStream.close();
        inputStream1.close();
    }
}
