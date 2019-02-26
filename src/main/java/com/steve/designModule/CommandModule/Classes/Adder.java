package com.steve.designModule.CommandModule.Classes;

/**
 * Created by liu on 4/2/17.
 * 请求接受者
 */
public class Adder {

    private int num = 0;

    public int add(int value){
        num += value;
        return num;
    }

}
