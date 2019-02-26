package com.steve.designModule.MediatorModule.Classes;


import com.steve.designModule.MediatorModule.Abstracts.Components;

/**
 * Created by liu on 4/6/17.
 * 显示客户信息总数
 */
public class Label extends Components {

    @Override
    public void update() {
        System.out.println("客户总数+1");
    }
}
