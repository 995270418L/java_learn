package com.steve.netty.codec.linebasedecodec;

import io.netty.buffer.ByteBuf;

/**
 * @Author: steve
 * @Date: Created in 15:45 2018/3/23
 * @Description:
 * @Modified By:
 */
public class Cmd {

    private final ByteBuf msg;
    private final ByteBuf args;

    public Cmd(ByteBuf msg, ByteBuf args) {
        this.msg = msg;
        this.args = args;
    }

    public ByteBuf getMsg() {
        return msg;
    }

    public ByteBuf getArgs() {
        return args;
    }

}
