package com.steve.ifeve.JavaNIO.ChannelDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by liu on 6/25/17.
 * DatagramChannel 可以接受UDP
 */
public class DatagramChannelDemo {

    public static void main(String... args){
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.socket().bind(new InetSocketAddress("http://crawler.site",80));
            receive(channel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过receive方法接收数据
     * @param channel
     */
    public static void receive(DatagramChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        channel.receive(buffer);
    }

    /**
     * 通过send方法发送数据
     * @param channel
     */
    public static void send(DatagramChannel channel) throws IOException {

        String newData = "This is Demo" + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(newData.getBytes());
        //切换模式
        buffer.flip();

        int byteBuffer = channel.send(buffer,new InetSocketAddress("http://crawler.site",80));

    }
}
