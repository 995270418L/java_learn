package com.steve.ifeve.JavaIo.ReaderAndWriter;

import java.io.*;

/**
 * Created by liu on 6/18/17.
 * BufferedReader 用来一块一块的读取字符
 */
public class BufferedReaderDemo {

    private static final String FILEPATH = "/home/liu/Desktop/chinese.txt";

    /**
     * 缓冲级读取
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
        String character = reader.readLine();
        while(character != null){
            System.out.println(character);
            character = reader.readLine();
        }
        reader.close();
    }

    /**
     * BufferedReader和inputStream整合
     */
//    public static void main(String... args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(new FileInputStream("/home/liu/Desktop/java.jpg"));
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String line = bufferedReader.readLine();
//        while(line != null){
//            System.out.println(line);
//            line = bufferedReader.readLine();
//        }
//        reader.close();
//        bufferedReader.close();
//    }

}
