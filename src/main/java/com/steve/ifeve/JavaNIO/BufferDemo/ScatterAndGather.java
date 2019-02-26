package com.steve.ifeve.JavaNIO.BufferDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liu on 6/23/17.
 * 分散(Scatter)和聚集(Gather)
 */
public class ScatterAndGather {

    /**
     * 将Channel的写入和读取都通过BufferArray来实现
     * @param args
     */
    public static void main(String... args) throws IOException {

        FileInputStream inputStream = new FileInputStream("/home/liu/Desktop/chinese.txt");
        FileChannel channel = inputStream.getChannel();
        /**
         * 设有两个buffer，一个保存信息头，一个保存信息体.
         */
        ByteBuffer buffer = ByteBuffer.allocate(48);
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer[] array = {buffer,buffer1};
        /**
         * 先将数据从channel中读入buffer,再读入buffer1.必须是静态的消息头才有用(因为大小是固定的).
         */
        long byteRead = channel.read(array);
        // ... Write也一样。
    }
}
