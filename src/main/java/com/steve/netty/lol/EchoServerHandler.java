package com.steve.netty.lol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.CharsetUtil;

/**
 * @Author: steve
 * @Date: Created in 9:35 2018/3/17
 * @Description: echo 服务端监听入站事件的处理
 * @Modified By:
 */
@Sharable  // 标记该handler可以被多个Channel共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter{   //这个是默认的入站事件的监听着父类实现

    /**
     * 接收到数据的处理
     * 默认是用来在ChannelPipeline中转发至下一个ChannelInboundHandler的，重写默认实现
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发来的信息: " + byteBuf.toString(CharsetUtil.UTF_8));
        // 客户端发来的信息是1，表明准备好了
//        if(byteBuf.equals("1")){
//
//        }
        ctx.write(msg);    // 将收到的信息写给发送者，不冲刷出站信息
    }

    /**
     * 接收数据完成的数据处理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel数据读取完毕...");
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE); // 关闭channel
    }

    /**
     * 异常处理方法
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 打印异常信息
        cause.printStackTrace();
        ctx.close(); // 关闭该channel
    }

}
