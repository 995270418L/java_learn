package com.steve.netty.udp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author: steve
 * @Date: Created in 8:59 2018/3/24
 * @Description:
 * @Modified By:
 */
public class LogEventToByteBuf extends MessageToMessageEncoder<LogEvent> {

    private final InetSocketAddress address;

    public LogEventToByteBuf(InetSocketAddress address) {
        this.address = address;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, LogEvent msg, List<Object> out) throws Exception {
        byte[] file = msg.getLogFile().getBytes();
        byte[] line = msg.getMsg().getBytes();
        ByteBuf buf = ctx.channel().alloc().buffer(file.length + line.length + 1); // 加上分隔符
        buf.writeBytes(file);
        buf.writeByte(msg.getSEPERATOR());
        buf.writeBytes(line);
        out.add(new DatagramPacket(buf,address)); // DatagramPacket 是用来支持 UDP 发送 bytebuf 类型的数据的
    }

}
