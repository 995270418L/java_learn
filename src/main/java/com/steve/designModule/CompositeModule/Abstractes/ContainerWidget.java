package com.steve.designModule.CompositeModule.Abstractes;

/**
 * Created by liu on 3/29/17.
 * 窗口控件
 */
public abstract class ContainerWidget extends GUI{

    public abstract void add(GUI gui);

    public abstract void remove(GUI gui);

    public abstract GUI getChild(int i);

}