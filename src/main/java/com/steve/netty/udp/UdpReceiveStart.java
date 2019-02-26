package com.steve.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

/**
 * @Author: steve
 * @Date: Created in 10:59 2018/3/24
 * @Description:
 * @Modified By:
 */
public class UdpReceiveStart {

    private final EventLoopGroup eventExecutors;
    private final Bootstrap bootstrap;


    public UdpReceiveStart(InetSocketAddress address){
        eventExecutors = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LogEventDecoder());
                        pipeline.addLast(new LogAggratorHandler());
                    }
                }).localAddress(address);
    }

    public Channel bind(){
        return bootstrap.bind().syncUninterruptibly().channel();
    }
    public void stop(){
        eventExecutors.shutdownGracefully();
    }

    public static void main(String... args){
        final UdpReceiveStart udpReceiveStart = new UdpReceiveStart(new InetSocketAddress(8000));
        try {
            Channel channel = udpReceiveStart.bind();
            System.out.println("Monitor run... ");
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            udpReceiveStart.stop();
        }
    }
}
