package com.steve.netty.webchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

/**
 * @Author: steve
 * @Date: Created in 20:38 2018/3/23
 * @Description:
 * @Modified By:
 */
public class ChatServer {

    private final ChannelGroup group = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);
    private final EventLoopGroup eventExecutors = new NioEventLoopGroup();
    private Channel channel;

    public static void main(String... args){
        System.out.println("正在监听 8000 端口上的事件");
        final ChatServer chatServer = new ChatServer();
        ChannelFuture f = chatServer.start(8000);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                chatServer.destroy();
            }
        });
        f.channel().closeFuture().syncUninterruptibly();
    }

    public ChannelFuture start(int port){
        ServerBootstrap b = new ServerBootstrap();
        b.group(eventExecutors)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)
                .childHandler(new ChatSocketInitalizer(group));
        ChannelFuture f = b.bind();
        f.syncUninterruptibly();
        channel = f.channel();
        return f;
    }

    public void destroy(){
        if(channel != null){
            channel.close();
        }
        group.close();
        eventExecutors.shutdownGracefully();
    }

}
