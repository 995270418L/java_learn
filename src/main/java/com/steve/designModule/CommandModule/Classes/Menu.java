package com.steve.designModule.CommandModule.Classes;

import com.steve.designModule.CommandModule.Abstracts.Command2;

import java.util.ArrayList;

/**
 * Created by liu on 4/3/17.
 * 请求发送者（具体请求者为子菜单）
 */
public class Menu {

    private String name;   // menu name

    private Command2 command2;

    private ArrayList<Menu> menuItem = new ArrayList();

    public Menu(String name){
        this.name = name;
    }

    public void setCommand2(Command2 command2){
        this.command2 = command2;
    }

    public void addMenuItem(Menu menu){
        menuItem.add(menu);
    }

    public void click(){
        command2.execute();
        for(Menu menu: menuItem){
            menu.command2.execute();
        }
    }
}
