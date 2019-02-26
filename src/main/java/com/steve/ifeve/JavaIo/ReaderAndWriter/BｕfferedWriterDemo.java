package com.steve.ifeve.JavaIo.ReaderAndWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by liu on 6/18/17.
 * BufferedWriter 实现缓存式写入字符
 */
public class BｕfferedWriterDemo {

    private static final String FILEPATH = "/home/liu/Desktop/BufferedWriterDemo";

    /**
     * BufferedWriter 写入字符进文件
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH));
        writer.write("new Fuck Contents");
        writer.flush();
        writer.close();
    }

}
