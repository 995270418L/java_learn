package com.steve.ifeve.multipartline.chapter3;

/**
 * Created by liu on 5/4/17.
 * 不安全的发布类
 */
public class Holder {

    private int n;

    public Holder(int n){
        this.n = n;
    }

    //没有使用同步来确保Holder对象对其他线程可见.
    public void assertSanity(){
        if (n != n){
            throw new AssertionError("This statement is false.");
        }
    }
}
