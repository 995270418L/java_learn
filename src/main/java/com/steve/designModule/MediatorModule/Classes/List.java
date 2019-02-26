package com.steve.designModule.MediatorModule.Classes;


import com.steve.designModule.MediatorModule.Abstracts.Components;

/**
 * Created by liu on 4/6/17.
 */
public class List extends Components {

    @Override
    public void update() {
        System.out.println("列表增加一项: 张无忌");
    }

    public void select(){
        System.out.println("列表选中一项: 小龙女");
    }

}
