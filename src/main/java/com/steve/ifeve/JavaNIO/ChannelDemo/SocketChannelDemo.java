package com.steve.ifeve.JavaNIO.ChannelDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by liu on 6/24/17.
 * 可以使用SocketChannel连接服务器读取和写入数据
 */
public class SocketChannelDemo {


    public static void main(String... args){
        try(SocketChannel channel = SocketChannel.open()) {
            //设置 SocketChannel 为非阻塞模式.设置之后，就可以在异步模式下调用connect(), read() 和write()了。
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("http://crawler.site",80));
            read(channel);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * SocketChannel　读取数据
     */
    public static void read(SocketChannel channel){
        ByteBuffer buffer = ByteBuffer.allocate(48);
        try {
            int byteRead = channel.read(buffer);
            while(byteRead != -1){
                System.out.print(byteRead+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String data, SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(data.getBytes());
        buffer.flip();
        // write方法无法保证写多少字节到buffer中,所以重复调用write方法直到buffer写满.
        while(buffer.hasRemaining()){
            channel.write(buffer);
        }
    }
}
