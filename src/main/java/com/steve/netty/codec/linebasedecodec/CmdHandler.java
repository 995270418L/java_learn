package com.steve.netty.codec.linebasedecodec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: steve
 * @Date: Created in 15:46 2018/3/23
 * @Description:
 * @Modified By:
 */
public class CmdHandler extends SimpleChannelInboundHandler<Cmd> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Cmd msg) throws Exception {
        // 这里得到的就是命令实体。可以调用shell执行的部分。

    }
}
