package com.steve.ifeve.JavaNIO.ChannelTransfer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by liu on 6/23/17.
 * 通道(FileChannel)之间的数据传输.SocketChannel的传输特性有所不同. 可以实现间接式的写入.
 * 参考文章: http://ifeve.com/java-nio-channel-to-channel/
 */
public class ChannelTransferDemo {

    public static final String FILEFORMPATH="/home/liu/Desktop/chinese.txt";
    public static final String FILETOPATH="/home/liu/Desktop/english";

    public static void main(String... args) throws IOException {
        RandomAccessFile from = new RandomAccessFile(FILEFORMPATH,"rw");
        FileChannel fromChannel = from.getChannel();

        RandomAccessFile to = new RandomAccessFile(FILETOPATH,"rw");
        FileChannel toChannel = to.getChannel();

        long position = 0;
        /**
         * 得到一次性写入的count
         */
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel,position,count);
    }
}
