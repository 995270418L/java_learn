package com.steve.netty.lol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: steve
 * @Date: Created in 10:00 2018/3/17
 * @Description:
 * @Modified By:
 */
public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        if(args.length != 1){
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
            return ;
        }
        Integer port = Integer.parseInt(args[0]);
        System.out.println("EchoServer 正在监听端口: " + port);
        new EchoServer().start(port);
    }

    public void start(Integer port) throws InterruptedException {
        EventLoopGroup groop = new NioEventLoopGroup();
        final EchoServerHandler handler = new EchoServerHandler();
        try {
            // 创建bootstrapServer
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 为引导服务绑定指定的handler和tcp/ip
            serverBootstrap
                    .group(groop)
                    .channel(NioServerSocketChannel.class)      // 指定使用Nio传输channel，还可以使用Oio
                    .localAddress(new InetSocketAddress(port))  // 监听指定端口的地址
                    .childHandler(new ChannelInitializer<SocketChannel>() {  // 为每个连接都创建一个子channel，
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(handler);
                        }
                    });
            ChannelFuture future = serverBootstrap.bind().sync();  // 阻塞操作直到绑定完成
            future.channel().closeFuture().sync();   // 阻塞直到服务器channel关闭
        }finally {
            groop.shutdownGracefully().sync();  // 释放所有资源.
        }
    }

}
