package com.steve.cow_guest.classes.c3;

/**
 * @Author: steve
 * @Date: Created in 19:12 2018/6/16
 * @Description:
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {
        StackGetMin sm = new StackGetMin();
        sm.push(4);
        sm.push(3);
        sm.push(5);
        System.out.println(sm.getMin());
        sm.push(6);
        sm.push(1);
        System.out.println(sm.getMin());
    }
}
