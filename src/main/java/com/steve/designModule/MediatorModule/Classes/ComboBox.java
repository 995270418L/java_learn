package com.steve.designModule.MediatorModule.Classes;


import com.steve.designModule.MediatorModule.Abstracts.Components;

/**
 * Created by liu on 4/6/17.
 */
public class ComboBox extends Components {
    @Override
    public void update() {
        System.out.println("组合框增加一项: 张无忌");
    }

    public void select(){
        System.out.println("组合框选中: 小龙女");
    }
}