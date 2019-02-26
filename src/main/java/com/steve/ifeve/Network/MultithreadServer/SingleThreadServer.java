package com.steve.ifeve.Network.MultithreadServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liu on 6/29/17.
 * 单线程的ThreadServer
 */
public class SingleThreadServer implements Runnable {

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;

    public SingleThreadServer(int port){
        this.serverPort = port;
    }

    @Override
    public void run() {

        // 获取当前线程对象
        synchronized (this){
            this.runningThread = Thread.currentThread();
        }

        openServerSocket();
        // 如果连接没有终止
        while(!isStopped){
            Socket clientSocket = null;
            try {
                // serverSocket接受客户端请求，并返回一个新的socket，这个方法会阻塞直到连接完成。
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()){
                    System.out.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e
                );
            }
            try {
                processClientRequest(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理客户端的socket连接
     * @param clientSocket
     */
    private synchronized void processClientRequest(Socket clientSocket) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        long time = System.nanoTime();

        outputStream.write(("HTTP/1.1 200 OK\n\n<html><body>" +
                "SingleThread Server: " + time +
                "</body></html>").getBytes());
        outputStream.close();
        System.out.println("Request processed: " + time);

        // stop();
    }

    private synchronized void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server",e);
        }
    }
}
