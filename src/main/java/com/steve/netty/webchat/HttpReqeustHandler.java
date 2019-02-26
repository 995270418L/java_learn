package com.steve.netty.webchat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;
import org.springframework.cache.annotation.CacheAnnotationParser;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Author: steve
 * @Date: Created in 19:13 2018/3/23
 * @Description:
 * @Modified By:
 */
@ChannelHandler.Sharable
public class HttpReqeustHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String WSURL;
    private static File INDEX;

    public HttpReqeustHandler(String wsUrl) {
        WSURL = wsUrl;
    }

    static {
//        URL location = HttpReqeustHandler.class.getProtectionDomain().getCodeSource().getLocation(); // 包路径的最前路劲 "target\classes\index.html"
        INDEX = new File("F:\\tools\\git\\java-learn\\src\\main\\java\\com\\steve\\netty\\webchat\\index.html");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        System.out.println("请求url: "  + request.uri());
        if(WSURL.equalsIgnoreCase(request.uri())){
            // 如果是这个ws的url,消息的引用+1
            ctx.fireChannelRead(request.retain());
        }else{
            RandomAccessFile file = new RandomAccessFile(INDEX,"r");
            HttpResponse response = new DefaultHttpResponse(request.protocolVersion(), HttpResponseStatus.OK);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html; charset=UTF-8");
            boolean keepAlive = HttpUtil.isKeepAlive(request);
            if(keepAlive) {
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, file.length());
            }
            ctx.write(response);
            if(ctx.pipeline().get(SslHandler.class) == null){
                ctx.write(new DefaultFileRegion(file.getChannel(),0,file.length()));
            }else{
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }
            ChannelFuture f = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT); // http context的结尾部分
            if(!keepAlive){
                f.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
