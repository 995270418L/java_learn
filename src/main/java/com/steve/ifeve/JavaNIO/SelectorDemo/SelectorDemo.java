package com.steve.ifeve.JavaNIO.SelectorDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by liu on 6/23/17.
 * 选择器示例，只能对应于SocketChannel，FileChannel没有非阻塞模式
 */
public class SelectorDemo {

    public static void main(String... args) throws IOException {
        //打开selector
        Selector selector = Selector.open();

        /**
         * 获取Socket Channel
         */
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 设置为非阻塞模式
        channel.configureBlocking(false);

        ServerSocket socket = channel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
        socket.bind(inetSocketAddress);

        channel.register(selector,SelectionKey.OP_ACCEPT);

        /**
         * 监听一个channel的ACCEPT事件 如果不止对一个事件感兴趣，可以使用连接符 |
         * @return selectionKey
         */
        // int ops = SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT ;
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            //this is a blocking method , it will blocking util channel be ready state. (ACCEPT).
            int readyChannel = selector.select();
            // no one channel be ready. next
            if(readyChannel == 0){
                break;
            }
            // 得到已就绪的channel
            Set selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while(iter.hasNext()){
                SelectionKey keys = iter.next();
                if(keys.isAcceptable()){
                    //收到服务端响应
                    System.out.println("#################################   Accept ");
                }
                if(keys.isConnectable()){
                    // 连接事件
                    System.out.println("#################################  Connectioned ");
                }
                if(keys.isReadable()){
                    // 读事件
                    System.out.println("################################ Readabled ");
                }
                if(keys.isWritable()){
                    // 写事件
                    System.out.println("################################ Writabled ");
                }
            }
        }

    }
}
