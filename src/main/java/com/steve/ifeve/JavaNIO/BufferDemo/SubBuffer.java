package com.steve.ifeve.JavaNIO.BufferDemo;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @Author: steve
 * @Date: Created in 10:07 2018/5/11
 * @Description: 子缓冲区
 * @Modified By:
 */
public class SubBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for(int i=0;i<intBuffer.capacity();i++){
            intBuffer.put(i);
        }

        intBuffer.position(3);
        intBuffer.limit(7);
        /**
         * slice 默认分隔源buffer的current position和limit position的位置
         *新创建的sliceBuffer
         */
        IntBuffer sliceBuffer = intBuffer.slice();

        for(int i=0;i<sliceBuffer.capacity();i++){
            // get()方法会增加read index，get(i)方法不会增加
            int a = sliceBuffer.get(i);
            a *= 10;
            // put(a) 方法也会增加read index
            sliceBuffer.put(a);
        }

        /**
         * 将当前position设为limit position，将current position设为0。这里的current position为3
         */
        intBuffer.flip();

//        intBuffer.position(0);
//        intBuffer.limit(intBuffer.capacity());

        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }

}
