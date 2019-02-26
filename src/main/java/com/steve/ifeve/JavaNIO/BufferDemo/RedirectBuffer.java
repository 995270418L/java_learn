package com.steve.ifeve.JavaNIO.BufferDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: steve
 * @Date: Created in 11:17 2018/5/11
 * @Description: 直接缓冲区，当需要直接对某个文件进行读取、写入的时候，确定没有别的文件对其进行使用的时候使用这个会显著提高效率。
 * @Modified By:
 */
public class RedirectBuffer {

    public static void main(String[] args) throws IOException {
        String source = "C:\\Users\\liu\\Desktop\\1.docx";
        FileInputStream inputStream = new FileInputStream(source);
        FileChannel fcin = inputStream.getChannel();

        String target = "C:\\Users\\liu\\Desktop\\1copy.docx";
        FileOutputStream outputStream = new FileOutputStream(target);
        FileChannel fout = outputStream.getChannel();

        //分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        while(true){
            int c = fcin.read(byteBuffer);

            if(c == -1){
                break;
            }

            byteBuffer.flip();
            fout.write(byteBuffer);
            byteBuffer.clear();
        }
    }

}
