package com.steve.ifeve.multipartline.chapter6;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by liu on 5/13/17.
 * 可以支持关闭操作的Web服务器
 */
public class LifecycleWebServer {

    /**
     * 开启一个拥有100个线程大小的线程池
     */
        private final ExecutorService exec = Executors.newFixedThreadPool(100);

    public void tstart() throws IOException {
        ServerSocket ss = new ServerSocket(80);
        while(!exec.isShutdown()){
            try{
                final Socket conn = ss.accept();
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        //这里处理请求
                        handlerRequest(conn);
                    }
                });
            }catch(RejectedExecutionException e){
                if(!exec.isShutdown()){
                    System.out.println("task submission rejected: " + e);
                }
            }
        }
    }

    public void stop(){
        exec.shutdown();
    }

    //处理请求
    private void handlerRequest(Socket conn) {

    }
}
