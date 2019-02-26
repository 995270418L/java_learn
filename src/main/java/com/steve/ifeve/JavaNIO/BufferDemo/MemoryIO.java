package com.steve.ifeve.JavaNIO.BufferDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: steve
 * @Date: Created in 11:46 2018/5/11
 * @Description: 内存型IO，只会将需要读-写改变的内容放入内存中。
 * @Modified By:
 */
public class MemoryIO {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\liu\\Desktop\\1.docx","rw");
        FileChannel fcin = file.getChannel();

        MappedByteBuffer mbb = fcin.map(FileChannel.MapMode.READ_WRITE,0,1024);

        mbb.put(0,(byte)97);
        mbb.put(1023,(byte)1023);

        fcin.close();
    }

}
