package com.steve.jvm.memoryAllocation;

/**
 * @Author: steve
 * @Date: Created in 12:40 2018/2/6
 * @Description: 对象优先储存进Eden区
 * @Modified By:
 */
public class EdenPriority {

    public static final int _1MB = 1024 * 1024;

//    public static void main(String[] args) {
//        byte[] b1 = new byte[2 * M];
//        byte[] b2 = new byte[2 * M];
//        byte[] b3 = new byte[2 * M];
//        byte[] b4 = new byte[4 * M];
//
////        System.gc();
//    }

    public static void main(String[] args) {

        byte[] b1,b2,b3,b4,b5,b6,b7;
        b1 = new byte[2 * _1MB];
        b2 = new byte[2 * _1MB];
        b3 = new byte[2 * _1MB];
        b1 = null;

        //这里进行第一次GC,把b1第一次引用的对象GC掉,同时把b2,b3引用的对象放入老年代,当前老年代占用了4M
        b4 = new byte[2 * _1MB];

        b5 = new byte[2 * _1MB];
        b6 = new byte[2 * _1MB];
        b4 = null;
        b5 = null;
        b6 = null;
        /**
         * 第二次GC
         * Survivor的空间不足存放b7引用的对象, 接下来执行的GC政策由HandlePromotionFailure来决定
         *
         * HandlePromotionFailure如果true(JDK16.0.24以后就可以当作一直是true,因为这个参数被无视了):
         * JVM会冒险进行一次Minor GC来使b7对象得到空间存放在新生代,如果GC后发现空间还是不足,则会进行一次Major GC(Full GC)
         *
         * HandlePromotionFailure如果false
         * JVM会直接进行Major GC(Full GC)
         */
        b7 = new byte[2*_1MB];
    }
}
