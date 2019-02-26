package com.steve.netty.udp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author: steve
 * @Date: Created in 10:42 2018/3/24
 * @Description: 将来自DatagramPacket的数据解码为LogEvent类型
 * @Modified By:
 */
public class LogEventDecoder extends MessageToMessageEncoder<DatagramPacket>{

    @Override
    protected void encode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
        ByteBuf bf = msg.content();
        final Charset utf8 = Charset.forName("UTF-8");
        int index = bf.indexOf(0,bf.readableBytes(),(byte)':'); // 获取 : 分隔符的位置
        String filename = bf.slice(0,index).toString(utf8);
        String content = bf.slice(index+1,bf.readableBytes()).toString(utf8);
        LogEvent logEvent = new LogEvent(msg.sender(),System.currentTimeMillis(),filename,content);  // 获取消息
        out.add(logEvent);
    }

}
