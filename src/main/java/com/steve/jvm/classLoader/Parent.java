package com.steve.jvm.classLoader;

/**
 * @Author: steve
 * @Date: Created in 19:06 2018/2/8
 * @Description:
 * @Modified By:
 */
public class Parent {

    static {
        System.out.println("Parent init。。。");
    }

    public static int p = 10;
    public static final int P = 20;

}
