package com.steve.ifeve.JavaNIO.ChannelDemo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liu on 6/21/17.
 * FileChannel使用示例
 */
public class FileChannelDemo {

    public static final String FILEPATH="/home/liu/Desktop/chinese.txt";

    /**
     * FileChannel 读取数据
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {

        RandomAccessFile file = new RandomAccessFile(FILEPATH,"rw");
        // 获取通道
        FileChannel channel = file.getChannel();
        // 初始化一个初始容量为48的ByteBuffer 单位是字节
        ByteBuffer buffer = ByteBuffer.allocate(48);
        //Reads a sequence of bytes from this channel into the given buffer.
        // buffer的写模式
        int byteRead = channel.read(buffer);
        while(byteRead != -1){
            System.out.println("Read: " + byteRead);
            // 反转buffer 将buffer从写模式切换到读模式
            buffer.flip();
            // 判断当前是否有元素位于current position和limit之间
            while(buffer.hasRemaining()){
                //Reads the byte at this buffer's
                //current position, and then increments the position.
                System.out.println(buffer.get());
            }
            // 读取完数据之后，需要清空buffer，以便再次写入数据
            buffer.clear();
            byteRead = channel.read(buffer);
        }
        file.close();
    }

    /**
     * FileChannel　写入数据
     * @param args
     * @throws IOException
     */
    public static void main2(String... args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("/home/liu/Desktop/chinese.txt","rw");
        FileChannel channel = accessFile.getChannel();
        String newData = "new String to write to file..." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        buffer.put(newData.getBytes());
        //切换写模式(默认模式)为读模式
        buffer.flip();
        while(buffer.hasRemaining()){
            channel.write(buffer);
        }
        channel.close();
        accessFile.close();
    }
}
