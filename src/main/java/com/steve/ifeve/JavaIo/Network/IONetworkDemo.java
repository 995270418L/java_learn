package com.steve.ifeve.JavaIo.Network;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by liu on 6/17/17.
 * 网络io示例
 */
public class IONetworkDemo {

    private static final String FILEPATH = "/home/liu/Desktop/java.jpg";

    public static void main(String... args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(FILEPATH);
        process(inputStream);
    }

    /**
     * 在这个方法里面对inputStream进行处理，而不用管inputStream来自什么地方（网络或者文件）
     * @param input
     */
    public static void process(InputStream input){
        // do something with inputStream
    }
}
