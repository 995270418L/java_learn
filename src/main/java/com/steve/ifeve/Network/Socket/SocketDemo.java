package com.steve.ifeve.Network.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by liu on 6/29/17.
 * 创建Socket对象通过TCP/IP网络协议连接到服务器(连接客户端)
 */
public class SocketDemo {

    public static void main(String... args) throws IOException {
        // 使用socket链接到一个已经存在的网络服务器
        Socket socket = new Socket("127.0.0.1", 80);

    }

    public static void getOutputstream(Socket socket) throws IOException {
        // 获得socket输出流
        OutputStream outputStream = socket.getOutputStream();
        // socket发送数据
        outputStream.write("Hello world".getBytes());
        // 调用flush()方法只是将数据写入操作系统缓存中，并不保证数据会立即发送
        outputStream.flush();
        outputStream.close();
        socket.close();
    }

    public static void getInputStream(Socket socket) throws IOException {

        InputStream inputStream = socket.getInputStream();

        /**
         * socket对象中只有当服务端关闭连接时，socket的输入流才会返回-1,
         *  事实上服务器并不会不停的关闭连接。因此，从Socket的输入流中读取数据时我们必须要知道需要读取的字节数，这可以通过让服务器在数据中告知发
         *  送了多少字节来实现，也可以采用在数据末尾设置特殊字符标记的方式连实现。
         */
        int data = inputStream.read();

        //使用完socket之后必须将Socket关闭
        socket.close();

    }

}
