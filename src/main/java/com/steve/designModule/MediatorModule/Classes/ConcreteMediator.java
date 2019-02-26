package com.steve.designModule.MediatorModule.Classes;


import com.steve.designModule.MediatorModule.Abstracts.Components;
import com.steve.designModule.MediatorModule.Abstracts.Mediator;

/**
 * Created by liu on 4/6/17.
 */
public class ConcreteMediator extends Mediator {

    //引用三个组件类i
    public Button button;   //按钮
    public List list;   //列表
    public ComboBox cb;   //组合框
    public TextBox tb;   //文本框

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
        }
    }


}
