package com.steve.designModule.CompositeModule.Classes;

import com.steve.designModule.CompositeModule.Abstractes.GUI;

/**
 * Created by liu on 3/29/17.
 * 文本框控件
 */
public class TextareaWidget extends GUI {

    private String name;

    public TextareaWidget(String name){
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println(" action to " + name + " textarea widget");
    }
}
