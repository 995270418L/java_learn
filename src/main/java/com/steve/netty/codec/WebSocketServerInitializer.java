package com.steve.netty.codec;

import io.netty.channel.*;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

/**
 * @Author: steve
 * @Date: Created in 10:46 2018/3/23
 * @Description: 将Http连接升级为WebSocket连接的一个handler
 * @Modified By:
 */
public class WebSocketServerInitializer extends ChannelInitializer<Channel> {

    private final SslContext sslContext;

    public WebSocketServerInitializer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 保护websocket，添加sslHandler。
        pipeline.addFirst(new SslHandler(sslContext.newEngine(ch.alloc())));
        pipeline.addLast(new HttpServerCodec(),
                // 为握手提供聚合的HttpRequest
                new HttpObjectAggregator((2 << 5) * 1024),
                // 如果被请求的端点是 /websocket, 则处理该升级握手。
                new WebSocketServerProtocolHandler("/websocket"),
                new TextFrameHandler(),
                new BinaryFrameHandler(),
                new ContinuationFrameHandler());
    }

    public static final class TextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
            System.out.println("text content: " + msg.text());
        }
    }

    public static final class BinaryFrameHandler extends SimpleChannelInboundHandler<BinaryWebSocketFrame>{

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) throws Exception {
            System.out.println(" receiced binary context");
        }
    }

    /**
     * 这是处理 多个 Frame 的 Handler
     */
    public static final class ContinuationFrameHandler extends SimpleChannelInboundHandler<ContinuationWebSocketFrame>{
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ContinuationWebSocketFrame msg) throws Exception {
            System.out.println("deal with more than 1 frame data ... ");
        }
    }

}
