package com.steve.netty.lol;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;

import java.util.Iterator;

/**
 * @Author: steve
 * @Date: Created in 23:11 2018/3/26
 * @Description:
 * @Modified By:
 */
public class LoLServerHandler extends ChannelInboundHandlerAdapter {

    private final ChannelGroup channelGroup;

    public LoLServerHandler(ChannelGroup channelGroup) {
        this.channelGroup = channelGroup;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 多余的客户端就丢弃
        if(channelGroup.size() < 5) {
            channelGroup.add(channel);
        }else if(channelGroup.size() ==  5){
            Iterator<Channel> channelIterator = channelGroup.iterator();
            while (channelIterator.hasNext()){
                channelIterator.next().writeAndFlush("are you ready ?");
            }
        }
    }



}
