package com.steve.netty.codec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @Author: steve
 * @Date: Created in 10:31 2018/3/23
 * @Description: 对Https的支持只需将sslHandler加入到pipeline中
 * @Modified By:
 */
public class HttpsCodecInitializer extends ChannelInitializer<Channel> {

    private final SslContext sslContext;
    private final Boolean client;

    public HttpsCodecInitializer(SslContext sslContext, Boolean client) {
        this.sslContext = sslContext;
        this.client = client;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        SSLEngine engine = sslContext.newEngine(ch.alloc());
        pipeline.addFirst("codec", new SslHandler(engine));
        if(client){
            pipeline.addLast("codec", new HttpClientCodec());
        }else{
            pipeline.addLast("codec", new HttpServerCodec());
        }
    }
}
