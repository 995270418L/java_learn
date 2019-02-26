package com.steve.ifeve.multipartline.chapter4;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liu on 5/8/17.
 * 文件扫描系统　生产者－消费者模式　利用BlockingQueue队列来实现
 */
public class FileCrawler implements Runnable {

    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root, File root1) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root1;
    }

    @Override
    public void run() {

    }

    private void crawler(File root) throws InterruptedException{
        File[] entries = root.listFiles(fileFilter);
        if(entries != null){
            for(File entry:entries){
                if(entry.isDirectory()){
                    crawler(entry);
                }else{
                    fileQueue.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File e){
        return false;
    }
}
