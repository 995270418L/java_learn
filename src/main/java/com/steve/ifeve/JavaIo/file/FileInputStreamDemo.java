package com.steve.ifeve.JavaIo.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by liu on 6/17/17.
 * java读取二进制文件 /home/liu/Desktop/java.jpg
 */
public class FileInputStreamDemo {

    /**
     * FileInputStream读取文件从开头到结尾的每一个字节
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String... args) throws IOException {
        FileInputStream inputStream = new FileInputStream("/home/liu/Desktop/chinese.txt");
        int count = 0;
        // 当　data = -1　的时候读取结束
        int data = inputStream.read();
        while(data != -1){
            // 控制台输出像素点　0 ~ 255
            System.out.print(data+" ");
            //　统计像素点个数
            count ++;
            data = inputStream.read();
        }
        System.out.println();
//        // 268555　个像素点
//        System.out.println(count);
        //　释放系统资源
        inputStream.close();
    }

    /**
     * 这种复制文件的方法效率肯定比javaNIO效率要低。
     * @throws IOException
     */
    public static void writeFile() throws IOException {
        FileInputStream inputStream = new FileInputStream("/home/liu/Desktop/chinese.txt");
        FileOutputStream outputStream = new FileOutputStream("/home/liu/Desktop/output.txt");
        int read = inputStream.read();
        while(read != -1){
            outputStream.write(read);
            read = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
