package com.steve.netty.transfer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: steve
 * @Date: Created in 19:40 2018/3/19
 * @Description: 异步阻塞的方式监听本地端口
 * @Modified By:
 */
public class NIOTransfer {

    public void server(int port) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);   // Non-Bloking I/O  就是设置一个非阻塞的同步IO，依然会轮询请求获取数据
        ServerSocket serverSocket = channel.socket();  // 获取socket连接
        serverSocket.bind(new InetSocketAddress(port));
        Selector selector = Selector.open();  // 打开selector来处理channel
        channel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hello".getBytes());  // 字节的方式发向客户端
        while(true){
            selector.select();   // 阻塞直到下一个需要传入的事件
            Set<SelectionKey> keys = selector.selectedKeys();   //获取所有接受事件的Selection-Key实例
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    // 每进来一个新连接，就为这个新连接注册一个读写处理器
                    if (key.isAcceptable()) {  // 检查事件是否是新的已经就绪可以被接受的连接
                        ServerSocketChannel client = (ServerSocketChannel) key.channel();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE & SelectionKey.OP_READ, msg.duplicate());   // 接受客户端，并将它注册到选择器
                        System.out.println("感应到了来自客户端: " + client + " 的连接");
                    }else if (key.isWritable()) {   // 检查套接字是否已经准备好写数据
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer bf = (ByteBuffer) key.attachment();
                        System.out.println("开始向客户端写数据: " + bf);
                        while (bf.hasRemaining()) {
                            if (client.write(bf) == 0) {   // 将数据写入到已连接的客户端
                                break;
                            }
                        }
                        client.close();
                    }
                }catch (IOException e){
                    key.cancel();
                    key.channel().close();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("监听来自9999 端口的请求");
        new NIOTransfer().server(9999);
    }
}
