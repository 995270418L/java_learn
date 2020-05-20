package com.steve.jvm.executor;

/**
 * jvm 字节码执行引擎里面的 动态连接 里面的 动态分配 知识点
 */
public class DynamicDispatcher {

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
    }

    static abstract class Human {
        abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        void sayHello() {
            System.out.println("Man say hello");
        }
    }

    static class Woman extends Human {

        @Override
        void sayHello() {
            System.out.println("Woman say hello");
        }
    }

}
