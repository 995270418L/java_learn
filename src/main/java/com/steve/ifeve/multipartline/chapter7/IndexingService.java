package com.steve.ifeve.multipartline.chapter7;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liu on 5/18/17.
 * 通过产生'毒丸'(poison pill)来关闭“生产者-消费者”服务 （此处是单个生产者-消费者对象）
 * 当消费者得到的是带有'毒丸'的对象时，就会终止消费，从而停止服务的继续运转
 */
public class IndexingService {
    private static final File Poison = new File("");
    private final CrawlerThread producer = new CrawlerThread();
    private final IndexerThread customer = new IndexerThread();
    private final BlockingQueue<File> queue;
    private final FileFilter fileFilter;
    private final File root;

    public IndexingService(BlockingQueue<File> queue, FileFilter fileFilter, File root) {
        this.queue = queue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    public void start(){
        producer.start();
        customer.start();
    }

    public void stop(){
        producer.interrupt();
    }

    public void awaitTermination() throws InterruptedException {
        customer.join(); // 等待生产者线程死亡
    }

    //消费者类
    class CrawlerThread extends Thread{

        public void run(){
            try{
                crawler(root);
            }catch (InterruptedException e){

            }finally{
                while(true){
                    try{
                        queue.put(Poison);
                    }catch (InterruptedException e){
                        //重新尝试
                    }
                }
            }
        }

        private void crawler(File file)throws InterruptedException{

        }
    }

    //生产者类
    class IndexerThread extends Thread{
        public void run(){
            try {
                while (true) {
                    File file = queue.take();
                    if (file.equals(Poison)){    //若是多个生产者-消费者模型，可以给这个posion对象增加一个计数器，
                        break; //当取到'毒丸'对象时,不再消费...
                    }else{
                        indexFile(file); // 消费文件
                    }
                }
            }catch(InterruptedException e){

            }
        }

        private void indexFile(File file) throws InterruptedException{

        }
    }
}
