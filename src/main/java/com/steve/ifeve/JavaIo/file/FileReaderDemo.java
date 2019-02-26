package com.steve.ifeve.JavaIo.file;

import java.io.*;

/**
 * Created by liu on 6/17/17.
 * java利用FileReader类读取文本文件　　/home/liu/Desktop/Data  costFunctionJ.m  f.sql  liu.pdf bwh.txt
 * 从文件开头一个字符字符的读到文件结尾
 */
public class FileReaderDemo {

    private static final String FILEPATH = "/home/liu/Desktop/chinese.txt";

    /**
     * FileReader使用指定的编码去解码字符，若需要自定义,需要使用InputStreamReader or FileInputStream
     * @param args
     * @throws IOException
     */
//    public static void main(String... args) throws IOException {
//        FileReader reader = new FileReader(FILEPATH);
//        // 返回的是字符的char类型值
//        int data = reader.read();
//        int count = 0;
//        while(data != -1){
//            // 读取出来的data是字符的　10位的unicode 编码 换行符是 10
//            System.out.print(data + " ");
//            count ++ ;
//            data = reader.read();
//        }
//        System.out.println();
//        System.out.println(count);
//        reader.close();
//    }

    // 使用BufferedReader将文件内容读取出来
    public static void main(String... args) throws IOException {
        //InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(FILEPATH), "utf-8");

        FileReader inputStreamReader = new FileReader(FILEPATH); // 默认还是 utf-8

        // 这个类的作用是 "Reads text from a character-input stream" 读取不转码的内容还是需要使用这个类
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();
        while(line != null){
            System.out.println(line);
            line = reader.readLine();
        }
        inputStreamReader.close();
        reader.close();
    }
}
