package com.steve.ifeve.multipartline.chapter7;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liu on 5/17/17.
 * 日志生成类（将生成的日志类放入BlockingQueue队列中），多生产者，单消费者模型
 */
public class LogWriter {

    private final BlockingQueue<String> queue;
    private final LoggerThread logger;

    public LogWriter(BlockingQueue<String> queue, LoggerThread thread) {
        this.queue = queue;
        this.logger = thread;
    }

    //生产log的方法
    public void log(String msg) throws InterruptedException {
        queue.put(msg);  //阻塞方法,抛出InterruptedException来声明中断状态
    }

    public void start(){
        logger.start();
    }

    private class LoggerThread extends Thread{

        private final PrintWriter writer;

        private LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        public void run(){
            try {
                while (true) {
                    writer.println(queue.take());
                }
            }catch(InterruptedException e){

            }finally{
                writer.close();
            }
        }
    }
}
