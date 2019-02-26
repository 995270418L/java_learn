package com.steve.designModule.CompositeModule.Classes;

import com.steve.designModule.CompositeModule.Abstractes.GUI;

/**
 * Created by liu on 3/29/17.
 * 按钮控件
 */
public class ButtonWidget extends GUI {

    private String name;

    public ButtonWidget(String name){
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println(" action to "+ name + " button widget");
    }

}
