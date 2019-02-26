package com.steve.ifeve.Network.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by liu on 6/30/17.
 * 能发送和接受UDP数据的DatagramSocket使用示例
 */
public class DatagramSocketDemo {

    public static void main(String... args){

    }

    /**
     * 发送udp数据，
     * @param datagramSocket
     * @throws IOException
     */
    public static void sendData(DatagramSocket datagramSocket) throws IOException {
        /**
         * udp 所能发送的最大数据(65508 byte)
         */
        byte[] buffer = new byte[65508];
        /**
         * 返回本用户所用电脑的localhost
         */
        InetAddress address = InetAddress.getLocalHost();
        /**
         * 新建一个代发送对象DatagramPacket,发送至　localhost的９０００端口(TCP协议和UDP协议对应的端口是不同意义的)
         */
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,9000);
        // 发送数据
        datagramSocket.send(packet);
    }

    public static void reveiceData(DatagramSocket datagramSocket) throws IOException {
        byte[] buffer = new byte[10];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        //有点类似javaNIO里面的channel　既可以读，也可以写。都是写入一个DatagramPacket里面的
        // 接收到的数据存储在DatagramPacket里面　可以这样读取
        // byte[] buffer = packet.getData();
        datagramSocket.receive(packet);
    }
}
