package com.steve.netty.codec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: steve
 * @Date: Created in 9:49 2018/3/23
 * @Description: 聚合HttpContext段发送给下一个 ChannelInboundHandler 的 Handler并添加到pipeline中
 * @Modified By:
 */
public class HttpAggregatorInitializer extends ChannelInitializer<Channel> {

    private final Boolean client;

    public HttpAggregatorInitializer(Boolean client) {
        this.client = client;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if(client){
            pipeline.addLast("client",new HttpClientCodec());
        }else{
            pipeline.addLast("server",new HttpServerCodec());
        }
        pipeline.addLast("aggregator",new HttpObjectAggregator(512*1024)); // 聚合512KB大小的数据。
    }
}
