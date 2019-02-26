package com.steve.netty.lol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: steve
 * @Date: Created in 12:28 2018/3/20
 * @Description:
 * @Modified By:
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 开始匹配计数
     */
    private int start = 0;

    /**
     * 接受的总数
     */
    private int accept = 0;

    private final ReentrantLock lock;

    public ServerHandler(ReentrantLock lock){
        this.lock = lock;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf bf = (ByteBuf) msg;
        String firstResult = bf.toString(Charset.forName("UTF-8"));
        if(firstResult.equals("1")){
            lock.lock();
            try {
                start++;
            } finally {
                lock.unlock();
            }
            if(start == 10){
                ctx.writeAndFlush("1".getBytes());  // 回写1，弹出准备或者接受的窗口
            }else {
                ctx.writeAndFlush("0".getBytes());  // 回写0,表示等待
            }
        }else if(firstResult.equals("accept")){
            lock.lock();
            try {
                accept++;
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000); // 等待1秒,观察accpet的数量
            if(accept == 10){
                ctx.writeAndFlush("start".getBytes());
            }else{
                Thread.sleep(9000); // 9秒等待时间
            }
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Map<String,String> map = new HashMap();
        map.put("liu","steve");
        super.exceptionCaught(ctx, cause);
    }

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Channel channel = new NioServerSocketChannel();
        group.register(channel);
        EventLoop eventLoop = channel.eventLoop();
        ScheduledFuture future = eventLoop.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Delay to say hello");
            }
        },1, 2,TimeUnit.SECONDS);
        future.cancel(false);
    }

}
