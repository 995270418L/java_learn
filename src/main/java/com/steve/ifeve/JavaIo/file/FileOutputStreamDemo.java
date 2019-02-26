package com.steve.ifeve.JavaIo.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by liu on 6/17/17.
 * javaio 利用FileOutputStream 写出二进制内容到文件中去  /home/liu/Desktop/fileoutputStream
 */
public class FileOutputStreamDemo {

    private static final String FILEPATH = "/home/liu/Desktop/";
    private static final String FILENAME = "fileOutputStream";

    /**
     * 实现将图片无损写入新文件中
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {
        FileInputStream inputStream = new FileInputStream(FILEPATH + "java.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH+FILENAME);
        int data = inputStream.read();
        while(data != -1){
            fileOutputStream.write(data);
            data = inputStream.read();
        }
        inputStream.close();
        fileOutputStream.close();
    }

}
