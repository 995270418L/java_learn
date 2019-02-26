package com.steve.designModule.CommandModule.Classes;


import com.steve.designModule.CommandModule.Abstracts.Command;

/**
 * Created by liu on 4/2/17.
 * 请求发送者
 */
public class CanculatorForm {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void canculator(int value){
        int i = command.execute(value);
        System.out.println("执行计算，计算结果为: " + i);
    }

    public void undo(){
        int i = command.undo();
        System.out.println("执行撤销，撤销结果为: " + i);
    }

    public void redo(){
        int i = command.redo();
        System.out.println("执行恢复操作,恢复结果为: " + i);
    }

}
