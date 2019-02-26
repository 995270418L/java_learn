package com.steve.ifeve.Network.MultithreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liu on 6/29/17.
 * 多线程serverSocket监听
 */
public class MultiThreadServer implements Runnable{

    protected  int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public MultiThreadServer(int serverPort){
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        openServerSocket();
        Socket clientSocket = null;
        while(!isStopped){
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                if(isStopped){
                    System.out.println("Server Stopped.");
                    return ;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e
                );
            }

            // 每遇到一个请求，就开启一个线程
            try {
                new Thread(
                        new WorkRunnable(clientSocket, "MultiThread server")
                ).start();
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
