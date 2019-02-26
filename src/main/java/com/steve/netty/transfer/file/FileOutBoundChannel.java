package com.steve.netty.transfer.file;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: steve
 * @Date: Created in 16:27 2018/3/23
 * @Description: 文件内容出站处理
 * @Modified By:
 */
@ChannelHandler.Sharable
public class FileOutBoundChannel extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        // 读取到数据的时候
        System.out.println("客户端收到数据 : " + msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        File file = new File("F:\\baiduyun\\java并发\\1.mp4");
        // 当建立连接的时候
        FileInputStream fileInputStream = new FileInputStream(file);
        // 零拷贝的实现版本
        long start = System.currentTimeMillis();
        FileRegion region = new DefaultFileRegion(fileInputStream.getChannel(),0,file.length());
        ctx.writeAndFlush(region).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("发送成功...");
                    System.out.println("发送的总字节数: " + region.count() + " 耗时: " + (System.currentTimeMillis() - start));
                }else{
                    System.err.println("发送失败");
                    future.cause().printStackTrace();
                }
            }
        });
    }
}
