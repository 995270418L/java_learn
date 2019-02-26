package com.steve.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: steve
 * @Date: Created in 22:15 2018/2/3
 * @Description: 内存溢出
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {
        List<Demo> list = new ArrayList();
        while(true){
            list.add(new Demo());
            break;
        }
        String a = "abc";
        a = "dcdv";
    }

}
