package com.steve.ifeve.multipartline.foundation;

/**
 * @Author: steve
 * @Date: Created in 18:32 2018/3/9
 * @Description:
 * @Modified By:
 */
public class ServerJvmArguementSaw {

    static boolean ready;
    static int number;
    public static void main(String[] args) {
        Thread t = new Thread(new DaemonThread());
        t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 守护线程示例
 */
class DaemonThread implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("I'm deamon thread");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
