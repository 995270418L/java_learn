package com.steve.jvm.tools;

import java.util.Scanner;

/**
 * @Author: steve
 * @Date: Created in 20:26 2018/2/6
 * @Description: Jconsole的线程工具查看
 * @Modified By:
 */
public class ThreadDemo {

    public static void main(String[] args) {

        Object obj1 = new Object();
        Object obj2 = new Object();

        // 死锁形成
        new Thread(new DeadLock(obj1,obj2),"obj1").start();
        new Thread(new DeadLock(obj2,obj1),"obj2").start();
    }
}
