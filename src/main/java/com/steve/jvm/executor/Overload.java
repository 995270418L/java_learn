package com.steve.jvm.executor;

/**
 * jvm 字节码执行引擎里面的 动态连接 里面的 静态分配 知识点
 */
public class Overload {

    public static void sayHello(Human args) {
        System.out.println("Human implement");
    }

    public static void sayHello(Man args) {
        System.out.println("Man implement");
    }

    public static void sayHello(Woman args) {
        System.out.println("Woman implement");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        sayHello(man);          // Human implement
        sayHello(woman);        // Human implement
    }

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

}