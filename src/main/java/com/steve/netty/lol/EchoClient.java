package com.steve.netty.lol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: steve
 * @Date: Created in 10:44 2018/3/17
 * @Description:
 * @Modified By:
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        if(args.length != 2){
            System.err.println("Usage : " + EchoClient.class.getSimpleName() + " <host> <port>");
            return ;
        }
        String host = args[0];
        Integer port = Integer.parseInt(args[1]);
        System.out.println("开始连接到远程服务, host: " + host + " port: " + port);
        new EchoClient(host,port).start();
    }

    public void start() throws InterruptedException {
        // 入站channel，从客户端发往服务端的信息。但为什么这个handler能同时处理出站消息呢？只不过是由于这个handler也实现了出战channel(ChannelHandlerAdapter)
        final EchoClientHandler echoClientHandler = new EchoClientHandler();
        EventLoopGroup groop = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            // 配置 Bootstrap 引导
            b.group(groop)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoClientHandler);
                        }
                    });
            ChannelFuture future = b.connect().sync();  //阻塞直到连接
            future.channel().closeFuture().sync();      //阻塞直到channel关闭
        }finally {
            groop.shutdownGracefully().sync();         // 释放资源(线程)
        }
    }
}
