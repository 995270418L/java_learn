package com.steve.ifeve.JavaNIO.BufferDemo;

import java.nio.IntBuffer;

/**
 * @Author: steve
 * @Date: Created in 23:09 2018/5/10
 * @Description:
 * @Modified By:
 */
public class IntBufferDemo {

    public static void main(String[] args) {

        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。
        IntBuffer intBuffer = IntBuffer.allocate(8);

        for(int i=0; i< intBuffer.capacity();i++){
            int j = 2*(i+1);
            intBuffer.put(j);
        }

        /**
         *  切换buffer的读写指针操作
         *  重设此缓冲区，将限制位置（8）设置为当前位置，然后将当前位置设置为0
         */
        intBuffer.flip();

        /**
         * 判断限制位置和当前位置是否有元素
         */
        while(intBuffer.hasRemaining()){
            int j = intBuffer.get();
            System.out.println(j + " ");
        }

    }
}
