package com.steve.netty.codec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: steve
 * @Date: Created in 10:10 2018/3/23
 * @Description:
 * @Modified By:
 */
public class HttpDecompressorInitializer extends ChannelInitializer<Channel> {

    private final Boolean client;

    public HttpDecompressorInitializer(Boolean client) {
        this.client = client;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if(client){
            pipeline.addLast("codec",new HttpClientCodec());
            // 对内容进行解压缩
            pipeline.addLast("decompressor",new HttpContentDecompressor());
        }else{
            pipeline.addLast("codec",new HttpServerCodec());
            // 对内容进行压缩。
            pipeline.addLast("compressor",new HttpContentCompressor());
        }
    }
}
