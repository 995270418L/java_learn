package com.steve.netty.udp;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: steve
 * @Date: Created in 10:53 2018/3/24
 * @Description:
 * @Modified By:
 */
@ChannelHandler.Sharable
public class LogAggratorHandler extends SimpleChannelInboundHandler<LogEvent> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent msg) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(msg.getReceived());
        sb.append(" [ ");
        sb.append(msg.getAddress().toString());
        sb.append(" ] [ ");
        sb.append(msg.getLogFile());
        sb.append(" ] : ");
        sb.append(msg.getMsg());
        System.out.println(sb.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
