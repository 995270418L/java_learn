package com.steve.ifeve.JavaIo.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by liu on 6/17/17.
 * 使用FileWriter将文本内容写入新文件中　/home/liu/Desktop/fileWriterDemo
 */
public class FileWriterDemo {

    private static final String FILEPATH = "/home/liu/Desktop/fileWriterDemo";

    // 将 "hello FileWriter" 写入示例文件中
    public static void main(String... args) throws IOException {
        FileWriter fileWriter = new FileWriter(FILEPATH);
        String demoString = "hello FileWriter";
        fileWriter.append(demoString);
        fileWriter.close();
    }
}
