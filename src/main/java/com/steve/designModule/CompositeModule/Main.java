package com.steve.designModule.CompositeModule;

import com.steve.designModule.CompositeModule.Abstractes.ContainerWidget;
import com.steve.designModule.CompositeModule.Abstractes.GUI;
import com.steve.designModule.CompositeModule.Classes.ButtonWidget;
import com.steve.designModule.CompositeModule.Classes.FrameworkWidget;
import com.steve.designModule.CompositeModule.Classes.MiddlePanel;
import com.steve.designModule.CompositeModule.Classes.TextareaWidget;

/**
 * Created by liu on 3/29/17.
 *    Sunny软件公司欲开发一个界面控件库,界面控件分为两大类,一类是单元控件,例如按
 * 钮、文本框等,一类是容器控件,例如窗体、中间面板等,试用组合模式设计该界面控件库。
 *
 */
public class Main {

    public static void main(String... args){
        GUI gui3,gui4,gui5,gui6;
        ContainerWidget gui,gui1,gui2;
        gui = new MiddlePanel("main framwwork");
        gui1 = new FrameworkWidget("close framework");
        gui2 = new MiddlePanel("popup framework");
        gui3 = new ButtonWidget("affirm button");
        gui4 = new TextareaWidget("form textarea");
        gui5 = new ButtonWidget("cancel button");
        gui6 = new TextareaWidget("forum textarea");
        gui1.add(gui3);
        gui1.add(gui4);
        gui2.add(gui5);
        gui2.add(gui6);
        gui.add(gui1);
        gui.add(gui2);
        gui.operation();
    }
}
