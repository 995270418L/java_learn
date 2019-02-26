package com.steve.ifeve.Network.MultithreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liu on 6/29/17.
 * 单线程太慢
 * 多线程太浪费资源
 * 只有线程池才能最大化利用已有的资源
 */
public class ThreadPooledServer implements Runnable{

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    // 初始化一个大小为 10 的线程池
    protected ExecutorService threadPool = (ExecutorService) Executors.newFixedThreadPool(10);
    public ThreadPooledServer(int serverPort){
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        openServerSocket();
        Socket clientSocket = null;
        while (!isStopped) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                if (isStopped) {
                    System.out.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e
                );
            }

            try {
                this.threadPool.execute(new WorkRunnable(clientSocket, "MultiThread server"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
