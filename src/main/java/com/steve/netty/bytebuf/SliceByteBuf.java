package com.steve.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Author: steve
 * @Date: Created in 9:24 2018/3/20
 * @Description:
 * @Modified By:
 */
public class SliceByteBuf {

    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf bf = Unpooled.copiedBuffer("Netty in Action rocks!".getBytes());
        ByteBuf newBf = bf.slice(0,15);  // 它可以避免内存复制的开销，而copy则会产生一个新的副本
        System.out.println(newBf.toString(utf8)); // 不添加指定编码会输出索引和capacity的值(一个包装类)
        bf.setByte(0,'J');
        System.out.println(bf.toString(utf8));  // 修改副本也会修改原来的
    }

}
