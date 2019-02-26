package com.steve.ifeve.Network.Socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by liu on 6/29/17.
 * 监听客户端TCP/IP端口连接(IO阻塞模式)
 */
public class ServerSocketDemo {

    public static void main(String... args) throws IOException {
        //监听8080端口
        ServerSocket socket = new ServerSocket(9000);

    }

}
