package com.steve.designModule.CommandModule;

import com.steve.designModule.CommandModule.Abstracts.Command2;
import com.steve.designModule.CommandModule.Classes.CreateCommand;
import com.steve.designModule.CommandModule.Classes.EditCommand;
import com.steve.designModule.CommandModule.Classes.Menu;
import com.steve.designModule.CommandModule.Classes.OpenCommand;

/**
 * Created by liu on 4/3/17.
 * 命令模式的组合模式
 * Sunny软件公司欲开发一个基于Windows平台的公告板系统。该系统提供了一个主菜单
 * (Menu),在主菜单中包含了一些菜单项(MenuItem),可以通过Menu类的addMenuItem()方
 * 法增加菜单项。菜单项的主要方法是click(),每一个菜单项包含一个抽象命令类,具体命
 * 令类包括OpenCommand(打开命令),CreateCommand(新建命令),EditCommand(编辑命令)
 * 等,命令类具有一个execute()方法,用于调用公告板系统界面类(BoardScreen)的open()、
 * create()、edit()等方法。试使用命令模式设计该系统,以便降低MenuItem类与BoardScreen
 * 类之间的耦合度。
 */
public class Main2 {

    public static void main(String... args){
        Command2 cm,cm2,cm3;
        cm = new OpenCommand();
        cm2 = new CreateCommand();
        cm3 = new EditCommand();
        Menu menu = new Menu("最小化");
        Menu menu1 = new Menu("最大化");
        Menu menu2 = new Menu("求助");
        menu.setCommand2(cm);
        menu1.setCommand2(cm2);
        menu2.setCommand2(cm3);
        menu.addMenuItem(menu1);
        menu.addMenuItem(menu2);
        menu.click();
    }
}
