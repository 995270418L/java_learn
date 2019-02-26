package com.steve.netty.bootstrap;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Author: steve
 * @Date: Created in 19:28 2018/3/22
 * @Description: 当客户端和服务器连接的时候，需要服务端提供的子Channel也作为一个第三方的客户端来与系统进行集成
 *      这里的还是一个服务端的Bootstrap
 * @Modified By:
 */
public class SubChannelBootstrap {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("监听本机端口80");
        new SubChannelBootstrap().server("https://www.manning.com/",8080);
    }

    public void server(String host,int port) throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInboundHandlerAdapter(){
                    ChannelFuture f = null;
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println("感受到了连接。。。。。");
                        final Charset UTF8 = Charset.forName("UTF-8");
                        Bootstrap bootstrap = new Bootstrap();
                        bootstrap.group(ctx.channel().eventLoop())
                                .channel(NioServerSocketChannel.class)
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                                        System.out.println("子Channel作为客户端和远程ip地址进行连接并获取的返回数据:" + msg.toString(UTF8));
                                    }
                                });
                        f = bootstrap.connect(new InetSocketAddress(host,80)).sync();
                    }

                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        // 和success的区别只是success关注的只是I/O操作完成情况,而done关注的是任务完成的情况。
                        if(f.isDone()){
                            System.out.println("子Channel作为第三方客户端的连接任务完成");
                        }else{
                            System.out.println("子Channel作为第三方客户端的连接任务还未完成");
                        }
                    }
                });
        ChannelFuture f = serverBootstrap.bind(new InetSocketAddress(port));
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("Server Bound.");
                }else{
                    System.err.println("Bind attempt failed.");
                    future.cause().printStackTrace();
                }
            }
        });
        f.channel().closeFuture().sync();
    }
}
