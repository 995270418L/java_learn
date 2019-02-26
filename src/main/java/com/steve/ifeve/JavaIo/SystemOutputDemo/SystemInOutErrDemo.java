package com.steve.ifeve.JavaIo.SystemOutputDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by liu on 6/17/17.
 * System.in System.out System.err示例
 */
public class SystemInOutErrDemo {

    /**
     * 这里演示　替换系统流　(其他几个就没啥意思了)
     * @param args
     */
    public static void main(String... args) throws FileNotFoundException {
        // System.out 重定向输出流　输出到自定义文件系统
        OutputStream outputStream = new FileOutputStream("/home/liu/Desktop/sytemOut");
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        System.out.println("这句话不会在控制台上显示");
        stream.flush();
        stream.close();
    }
}
