package com.steve.designModule.CompositeModule.Classes;

import com.steve.designModule.CompositeModule.Abstractes.ContainerWidget;
import com.steve.designModule.CompositeModule.Abstractes.GUI;

import java.util.ArrayList;

/**
 * Created by liu on 3/29/17.
 * 中间面板
 */
public class MiddlePanel extends ContainerWidget {

    private String name;
    private ArrayList<GUI> list = new ArrayList<>();

    public MiddlePanel(String name){
        this.name = name;
    }

    //add remove getChild方法
    @Override
    public void add(GUI gui){
        list.add(gui);
    }

    @Override
    public void remove(GUI gui){
        list.remove(gui);
    }

    @Override
    public GUI getChild(int i){
        return list.get(i);
    }

    @Override
    public void operation() {
        System.out.println(" action to " +name+ " middlwpanel widget" );

        for(GUI g: list){
            g.operation();
        }
    }
}
