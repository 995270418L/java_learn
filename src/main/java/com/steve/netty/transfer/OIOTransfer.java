package com.steve.netty.transfer;

import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Author: steve
 * @Date: Created in 19:29 2018/3/19
 * @Description: 同步连接接受请求
 * @Modified By:
 */
public class OIOTransfer {
    public void server(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        for(;;) {
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from " + clientSocket);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream out = null;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("Hello".getBytes(Charset.forName("UTF-8")));
                        out.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("开启对本地网络端口8888的监听");
        new OIOTransfer().server(8888);
    }
}
