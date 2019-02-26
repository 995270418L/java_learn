package com.steve.ifeve.JavaIo.ByteandCharArrays;

import java.io.*;

/**
 * Created by liu on 6/17/17.
 * 通过ByteArrayInputStream将字节数组转换成inputStream流输出　
 */
public class BytaArrayInputStreamDemo {

    /**
     * 字节数组转化示例
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {
        byte[] bytes = new byte[1024];

        InputStream inputStream = new ByteArrayInputStream(bytes);
        int data = inputStream.read();
        while(data != -1){
            System.out.println(data + " ");
            data = inputStream.read();
        }
        inputStream.close();
    }

    /**
     * 字符类型转化示例
     * @param args
     */
//    public static void main(String... args) throws IOException {
//        char[] chars = new char[1024];
//
//        Reader reader = new CharArrayReader(chars);
//
//        int data = reader.read();
//        while(data != -1){
//            System.out.println(data + " ");
//            data = reader.read();
//        }
//        reader.close();
//    }
}
