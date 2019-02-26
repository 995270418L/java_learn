package com.steve.netty.codec.linebasedecodec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @Author: steve
 * @Date: Created in 15:48 2018/3/23
 * @Description: 这个解码专门解析以\n \r\r结尾的ByteBuf,再在里面截取以' '分割的字节码，组成一个命令。增加传输性能.
 * @Modified By:
 */
public class CmdDecoder extends LineBasedFrameDecoder {

    private final Byte SPACE = ' ';
    public CmdDecoder(int maxLength) {
        super(maxLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
        if(frame == null){
            return null;
        }
        int index = frame.indexOf(frame.readerIndex(),frame.writerIndex(),SPACE);
        ByteBuf msg = frame.slice(frame.readerIndex(),index);
        ByteBuf args = frame.slice(index+1,frame.writerIndex());
        return new Cmd(msg,args);
    }

}
