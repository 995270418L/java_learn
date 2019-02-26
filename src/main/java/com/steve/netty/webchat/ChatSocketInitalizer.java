package com.steve.netty.webchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Author: steve
 * @Date: Created in 20:35 2018/3/23
 * @Description:
 * @Modified By:
 */
public class ChatSocketInitalizer extends ChannelInitializer<Channel> {

    private final ChannelGroup channels;

    public ChatSocketInitalizer(ChannelGroup channels) {
        this.channels = channels;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec(),new ChunkedWriteHandler(),
                new HttpObjectAggregator(64*1024), new HttpReqeustHandler("/ws"),
                new WebSocketServerProtocolHandler("/ws"), new TextWebSocketHandler(channels));
    }

}
