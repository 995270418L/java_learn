package com.steve.designModule.MediatorModule.Classes;

import com.steve.designModule.MediatorModule.Abstracts.Components;

/**
 * Created by liu on 4/6/17.
 */
public class TextBox extends Components {
    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空");
    }
    public void setText(){
        System.out.println("文本框显示:小龙女");
    }
}
