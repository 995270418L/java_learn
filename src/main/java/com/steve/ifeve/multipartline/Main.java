package com.steve.ifeve.multipartline;

/**
 * Created by liu on 4/9/17.
 */
public class Main {

    public static void main(String... args){
        System.out.println(xorShift(10));
    }
    /**
     * 随机数生成器
     * @param y
     * @return
     */
    public static int xorShift(int y){
        y ^= (y << 6);   // y = y ^ (y * 2^6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }
}
