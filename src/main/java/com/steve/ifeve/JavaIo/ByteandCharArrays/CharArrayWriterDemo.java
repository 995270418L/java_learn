package com.steve.ifeve.JavaIo.ByteandCharArrays;

import java.io.CharArrayWriter;

/**
 * Created by liu on 6/17/17.
 * 从Writer或者outputStream流中写出字符数组或者字节数组
 */
public class CharArrayWriterDemo {

    /**
     * 写出字节数组
     */
//    public static void main(String... args) throws IOException {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        outputStream.write("this will be write to byte array ".getBytes("UTF-8"));
//        byte[] bytes = outputStream.toByteArray();
//    }

    /**
     * 写出字符数组
     */
    public static void main(String... args){
        CharArrayWriter writer = new CharArrayWriter();
        writer.append("fuck");
        char[] character = writer.toCharArray();
    }
}
