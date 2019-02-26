package com.steve.netty.bootstrap;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Author: steve
 * @Date: Created in 20:28 2018/3/22
 * @Description: ChannelOption的用法，给channel绑定id属性
 * @Modified By:
 */
public class AttrClientChannel {

    public static void main(String[] args) {
        System.out.println("remote address: locahost, port is 8000 is listening. ");
        new AttrClientChannel().server();
    }

    public void server(){
        Bootstrap bootstrap = new Bootstrap();
        final AttributeKey<Integer> id = AttributeKey.newInstance("ID");
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                        System.out.println("received data form localhost: 8000 :" + msg.toString(Charset.forName("UTF-8")));
                    }

                    /**
                     * when registered ,it will contained the id attribute.
                     * @param ctx
                     * @throws Exception
                     */
                    @Override
                    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                        Integer userId = ctx.channel().attr(id).get();
                        System.out.println("user id is : " + userId);
                    }
                }).remoteAddress(new InetSocketAddress("localhost",8000));
        bootstrap.option(ChannelOption.SO_KEEPALIVE,true).option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000);
        bootstrap.attr(id,123456);
        ChannelFuture f = bootstrap.connect().syncUninterruptibly();
        try {
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully(); // 异步的关闭和释放所有的资源，返回一个future实现
        }
    }
}
