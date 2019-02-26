package com.steve.ifeve.JavaIo.file;

import java.io.*;

/**
 * Created by liu on 6/17/17.
 * 跳跃式读取文件内容 RandomAccessFile 暂时有点搞不明白这个类的write方法的使用
 */
public class RandomAccessFileDemo {

    private static final String FILEPATH = "/home/liu/Desktop/fileOutputStream.txt";

    /**
     * 实现目标：　在文件的15字节开始插入java 这一单词 后面追加一个空格
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {
        // mode 共有"r","rw","rws","rwd"四种
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILEPATH , "rw");
        long location = 15;   // location
        byte[] java = "java ".getBytes();
        // 给新文件设置长度
        randomAccessFile.setLength(randomAccessFile.length() + java.length); // 从这里开始randomAccessFile的长度就改变了
        for(long i = randomAccessFile.length() - 1 ; i > java.length + location - 1 ; i--){
            randomAccessFile.seek(i - java.length);
            byte tmp = randomAccessFile.readByte();
            randomAccessFile.seek(i);
            randomAccessFile.writeByte(tmp);
        }
//        for(long i = randomAccessFile.length() + java.length - 1 ; i > java.length + location - 1 ; i --){
//            randomAccessFile.seek(i - java.length);
//            byte tmp = randomAccessFile.readByte();
//            randomAccessFile.seek(i);
//            randomAccessFile.writeByte(tmp);
//        }
        randomAccessFile.seek(location);
        randomAccessFile.write(java);
        randomAccessFile.close();
        System.out.println("file content: " + content(FILEPATH));
        System.out.println("file length: " + len(FILEPATH));
    }

    public static int len(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        int data = reader.read();
        int count = 0;
        while(data != -1){
            count ++;
            data = reader.read();
        }
        return count;
    }

    public static String content(String filepath) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filepath));
        StringBuilder sb = new StringBuilder();
        BufferedReader read = new BufferedReader(reader);
        String line = read.readLine();
        while(line != null){
            sb.append(line).append("\n");
            line = read.readLine();
        }
        return sb.toString();
    }
}
