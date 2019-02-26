package com.steve.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Author: steve
 * @Date: Created in 9:37 2018/3/20
 * @Description:
 * @Modified By:
 */
public class ReadWriteByteBuf {

    public static void main(String[] args) {
        ByteBuf bf = Unpooled.directBuffer();
        int readIndex = bf.readerIndex();
        int writeIndex = bf.writerIndex();
        System.out.println("readIndex: " + readIndex + " writeIndex: " + writeIndex);
        if(bf.isWritable(1)){
            bf.writeByte((byte)'L');
        }
        System.out.println("readIndex: " + bf.readerIndex() + " writeIndex: " + bf.writerIndex());
    }

}
