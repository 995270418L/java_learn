package com.steve.ifeve.Network.MultithreadServer;

/**
 * Created by liu on 6/29/17.
 * 测试自己写的多线程监听服务器的效果
 */
public class Main {

    public static void main(String... args){
        //SingleThreadServer server = new SingleThreadServer(9000);
        MultiThreadServer server = new MultiThreadServer(9000);
        new Thread(server).start();

        try{
            Thread.sleep(1000*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }

}
