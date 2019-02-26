package com.steve.designModule.CompositeModule.Classes;


import com.steve.designModule.CompositeModule.Abstractes.ContainerWidget;
import com.steve.designModule.CompositeModule.Abstractes.GUI;

import java.util.ArrayList;

/**
 * Created by liu on 3/29/17.
 * 窗体控件
 */
public class FrameworkWidget extends ContainerWidget {

    private String name;
    private ArrayList<GUI> list = new ArrayList<>();

    public FrameworkWidget(String name){
        this.name= name;
    }

    //add remove getChild　方法
    @Override
    public void add(GUI gui){
        list.add(gui);
    }

    @Override
    public void remove(GUI gui){
        list.remove(gui);
    }

    //获取该控件下的子控件
    @Override
    public GUI getChild(int i){
        return list.get(i);
    }

    @Override
    public void operation() {
        System.out.println(" actione to "+ name +" framework widget");
        for(GUI g : list){
            g.operation();
        }
    }
}
