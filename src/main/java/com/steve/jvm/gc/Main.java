package com.steve.jvm.gc;

/**
 * @Author: steve
 * @Date: Created in 10:50 2018/2/6
 * @Description: 证明现在的垃圾回收算法，非标记-清除算法
 * @Modified By:
 */
public class Main {

    public Main(){
        byte[] bytes = new byte[20 * 1024 * 1024];
    }

    private Object instance;

    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main();

        // 实例互相指向
        m1.instance = m2;
        m2.instance = m1;

        // 清除栈的相互指向（所以理论上对象不会被清除，因为都有引用）
        m1 = null;
        m2 = null;

        // 手动调用垃圾回收，需添加两个运行参数 -verbose:gc -XX:+PrintGCDetails
        System.gc();

    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }
}
