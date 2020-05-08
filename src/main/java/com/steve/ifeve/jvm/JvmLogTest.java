package com.steve.ifeve.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * windows 需要 openjdk14 才支持 -XX:+UseZGC
 */
public class JvmLogTest {

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            str.add("str" + i);
        }
        str = null;
        System.gc();
        System.out.println("over");
    }
}
