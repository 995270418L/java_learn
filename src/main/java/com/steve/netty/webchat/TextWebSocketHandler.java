package com.steve.netty.webchat;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * @Author: steve
 * @Date: Created in 20:06 2018/3/23
 * @Description: 处理socket文本消息
 * @Modified By:
 */
@ChannelHandler.Sharable
public class TextWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final ChannelGroup channelGroup;

    public TextWebSocketHandler(ChannelGroup channelGroup) {
        this.channelGroup = channelGroup;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 异步操作,必须保留引用.
        channelGroup.writeAndFlush(msg.retain());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof WebSocketServerProtocolHandler.HandshakeComplete){
            System.out.println("webSocket message");
            ctx.pipeline().remove(HttpReqeustHandler.class);
            channelGroup.writeAndFlush(new TextWebSocketFrame("client " + ctx.channel() + " joined" ));
            channelGroup.add(ctx.channel());
        }else{
            super.userEventTriggered(ctx,evt);
        }
    }
}
