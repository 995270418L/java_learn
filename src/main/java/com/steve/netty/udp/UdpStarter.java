package com.steve.netty.udp;

import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

/**
 * @Author: steve
 * @Date: Created in 9:55 2018/3/24
 * @Description:
 * @Modified By:
 */
public class UdpStarter {

    private final EventLoopGroup group;
    private final Bootstrap bootstrap;
    private final File file;


    public UdpStarter(InetSocketAddress address, File file){
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST,true).handler(new LogEventToByteBuf(address));
        this.file = file;
    }

    public void start() throws Exception {
        Channel ch = bootstrap.bind(0).sync().channel();
        long pointer = 0;
        for(;;){
            long len = file.length();
            if(len < pointer){
              pointer = len;
            } else if (len > pointer){
                RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
                randomAccessFile.seek(pointer);
                String line = null;
                while(( line = randomAccessFile.readLine() ) != null){
                    ch.writeAndFlush(new LogEvent(null,-1,file.getAbsolutePath(),line));
                }
                pointer = randomAccessFile.getFilePointer();
                randomAccessFile.close(); //切记一定要关闭
        }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                Thread.interrupted();
                break;
            }
        }
    }

    public void stop(){
        group.shutdownGracefully();
    }

    public static void main(String[] args) {
        System.out.println("UDP starter ... 8000 ");
        final UdpStarter udpStarter = new UdpStarter(new InetSocketAddress("255.255.0.0",8000),new File("D:\\log.txt"));
        try{
            udpStarter.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            udpStarter.stop();
        }
    }

}
