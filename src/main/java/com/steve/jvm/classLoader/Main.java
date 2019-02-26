package com.steve.jvm.classLoader;

/**
 * @Author: steve
 * @Date: Created in 19:08 2018/2/8
 * @Description:
 * @Modified By:
 */
public class Main {

    /**
     * 总结:
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(Child.p);   // 输出说明父类初始化了，而子类没初始化
        //System.out.println(Child.P);     // 输出说明父类和子类都没初始化.
        Child[] children = new Child[10];  // 输出说明父类和子类都没初始化
    }

}
