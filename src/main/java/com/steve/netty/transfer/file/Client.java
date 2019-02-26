package com.steve.netty.transfer.file;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: steve
 * @Date: Created in 16:40 2018/3/23
 * @Description:
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {
        int port = 8000;
        System.out.println("建立本地socket,端口为:" + port);
        new Client().server(port);
    }

    public void server(int port){
        Bootstrap b = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new FileOutBoundChannel());
                        }
                    });
            ChannelFuture f = b.connect(new InetSocketAddress("localhost",port));
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("成功建立连接...");
                    } else {
                        System.err.println("建立连接失败....");
                        future.cause().printStackTrace();
                    }
                }
            });
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}
