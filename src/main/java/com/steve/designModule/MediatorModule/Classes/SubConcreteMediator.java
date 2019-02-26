package com.steve.designModule.MediatorModule.Classes;

import com.steve.designModule.MediatorModule.Abstracts.Components;

/**
 * Created by liu on 4/6/17.
 */
public class SubConcreteMediator extends ConcreteMediator {

    public Label label;

    @Override
    public void changeComponent(Components c) {
        //列表选中
        if(c == list){
            System.out.println("从列表框选择客户!");
            c.update();
            tb.setText();
        }else if(c == cb){
            System.out.println("从组合框选中客户!");
            cb.select();
            tb.setText();
        }else if(c == button){
            System.out.println("单击增加按钮");
            list.update();
            cb.update();
            tb.setText();
            label.update();
        }
    }
}
