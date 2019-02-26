package com.steve.netty.transfer.file;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: steve
 * @Date: Created in 16:31 2018/3/23
 * @Description: 文件入站处理.
 * @Modified By:
 */
@ChannelHandler.Sharable
public class FileInputBoundChannel extends ChannelInboundHandlerAdapter {

    private final File file;

    public FileInputBoundChannel(File file) {
        this.file = file;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //当读取客户端数据完成时,回写一个文件
//        super.channelReadComplete(ctx);
        System.out.println("数据读取完毕,开始发送文件");
        ctx.writeAndFlush(new FileInputStream(file));

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("读取到了数据...: " + msg.toString());
    }
}
