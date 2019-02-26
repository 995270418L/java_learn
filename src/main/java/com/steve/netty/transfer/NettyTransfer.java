package com.steve.netty.transfer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.nio.charset.Charset;

/**
 * @Author: steve
 * @Date: Created in 20:37 2018/3/19
 * @Description: 通过 netty 使用 OIO 和 NIO
 * @Modified By:
 */
public class NettyTransfer {

    public void oioNetty(int port){
        final ByteBuf bf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hello,client", Charset.forName("UTF-8")));
        EventLoopGroup group = new OioEventLoopGroup();     // 换成NioEventLoopGroup 就成了NIO形式的
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(OioServerSocketChannel.class)  // 换成NioServerSocketChannel 就成了NIO形式的
                    .localAddress(port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    // 接受到请求的时候，它会把指定的信息返回给客户端
                                        ctx.writeAndFlush(bf.duplicate()).addListener(new ChannelFutureListener() {
                                        @Override
                                        public void operationComplete(ChannelFuture future) throws Exception {
                                            if(future.isSuccess()){
                                                // 成功写入
                                                System.out.println("已向客户端写入数据...");
                                            }else{
                                                System.err.println("写数据出错");
                                                // 打印异常
                                                future.cause().printStackTrace();
                                            }
                                            future.channel().close();
                                        }

                                    });
//                                    ctx.write(bf);
                                    // 调用下一个channelHandler去处理这个请求
                                    super.channelActive(ctx);
                                }
                            });
                        }
                    });
            ChannelFuture f = b.bind().sync(); // 绑定服务器以接受连接
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("开始监听本机的11111端口的客户端请求");
        new NettyTransfer().oioNetty(11111);
    }
}
