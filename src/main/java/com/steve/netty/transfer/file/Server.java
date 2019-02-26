package com.steve.netty.transfer.file;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.io.File;

/**
 * @Author: steve
 * @Date: Created in 16:44 2018/3/23
 * @Description:
 * @Modified By:
 */
public class Server {

    public static void main(String[] args) {
        int port = 8000;
        String filePath = "F:\\baiduyun\\java并发\\1.mp4";
        System.out.println("正在监听本地端口: " + port);
        new Server().server(port,filePath);
    }

    public void server(int port,String filePath){
        ServerBootstrap sb = new ServerBootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        final FileInputBoundChannel channel = new FileInputBoundChannel(new File(filePath));
        try{
            sb.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChunkedWriteHandler(),channel);
                        }
                    });
            ChannelFuture f = sb.bind();
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        System.out.println("绑定成功");
                    }else{
                        System.err.println("绑定失败 : ");
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
