package com.steve.jvm.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: steve
 * @Date: Created in 19:43 2018/2/6
 * @Description: Jconsole类运行的时候可以查看Jconsole的内存管理界面，查看变化内存趋势
 * @Modified By:
 */
public class Jconsole {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        fill(1000);
    }

    private static void fill(int n) throws InterruptedException {
        List<Object> lists = new ArrayList();
        for(int i=0;i <n; i++){
            Thread.sleep(100);
            lists.add(new Object());
        }
    }
}
