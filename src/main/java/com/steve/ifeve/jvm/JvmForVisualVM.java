package com.steve.ifeve.jvm;

import java.util.ArrayList;
import java.util.List;

public class JvmForVisualVM {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        method1(1, 10000);
    }

    public static void method1(int start, int end) throws InterruptedException {
        List<String> list = new ArrayList();
//        while(true){
        for (int i = start; i < end; i++) {
            list.add("string");
        }
        Thread.sleep(3000);
        list = new ArrayList<>();
        System.out.println("loop");
//        }
    }
}
