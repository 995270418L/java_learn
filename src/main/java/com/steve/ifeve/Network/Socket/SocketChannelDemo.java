package com.steve.ifeve.Network.Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by liu on 6/29/17.
 * 调用javaNIO的api实现网络通信(TCP/IP　连接客户端)
 */
public class SocketChannelDemo {

    public static void main(String... args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //　当设置为阻塞模式时，connect ,write ,read方法必须要监控，否则不一定有数据
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",80));
    }

    /**
     * 获取输入流
     * @param socketChannel
     */
    public static void getOutputStream(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        //　if byteRead = -1 connect closed.
        int byteRead = socketChannel.read(buffer);
    }

    /**
     * 获取输出流
     * @param socketChannel
     */
    public static void getInputStream(SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.clear();
        byteBuffer.put("New_String".getBytes());
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            socketChannel.write(byteBuffer);
        }
    }


}
