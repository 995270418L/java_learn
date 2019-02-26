package com.steve.netty.codec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @Author: steve
 * @Date: Created in 9:27 2018/3/23
 * @Description: 将ssl/tls支持添加到handler的pipeline中去
 * @Modified By:
 */
@ChannelHandler.Sharable
public class SslPipelineInitializer extends ChannelInitializer<Channel> {

    private final SslContext sslContext;
    private final Boolean startTls;  // 判断第一个写入的消息是否需要加密。true为不需要加密，客户端一般为true。

    public SslPipelineInitializer(SslContext sslContext, Boolean startTls) {
        this.sslContext = sslContext;
        this.startTls = startTls;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        SSLEngine sslEngine = sslContext.newEngine(ch.alloc());
        ch.pipeline().addFirst("ssl",new SslHandler(sslEngine,startTls));
    }

}
