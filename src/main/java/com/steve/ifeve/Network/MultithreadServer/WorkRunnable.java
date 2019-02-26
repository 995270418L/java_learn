package com.steve.ifeve.Network.MultithreadServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by liu on 6/29/17.
 */
public class WorkRunnable implements Runnable {

    private Socket clientSocket = null;
    private String serverText;
    public WorkRunnable(Socket socket, String text) throws IOException {
        this.clientSocket = socket;
        this.serverText = text;
    }

    @Override
    public void run() {
        try{
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
                    this.serverText + " - " +
                    time +
                    "").getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
