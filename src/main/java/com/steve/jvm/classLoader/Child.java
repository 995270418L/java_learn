package com.steve.jvm.classLoader;

/**
 * @Author: steve
 * @Date: Created in 19:07 2018/2/8
 * @Description:
 * @Modified By:
 */
public class Child extends Parent {

    static {
        System.out.println("Child init。。。");
    }
}
