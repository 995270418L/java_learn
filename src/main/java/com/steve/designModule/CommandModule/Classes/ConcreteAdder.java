package com.steve.designModule.CommandModule.Classes;


import com.steve.designModule.CommandModule.Abstracts.Command;

import java.util.Stack;

/**
 * Created by liu on 4/2/17.
 */
public class ConcreteAdder extends Command {

    private Adder add = new Adder();
    private int tmp ;
    //保存内部状态的类
    private Stack<Integer> stack = new Stack();

    @Override
    public int execute(int value) {
        stack.push(value);
        return add.add(value);
    }

    //二次撤销方法
    @Override
    public int redo() {
        return add.add(tmp);
    }

    //撤销方法
    @Override
    public int undo() {
        if(!stack.empty()){
            tmp = stack.pop();
            return add.add(-tmp);
        }else{
            return 0;
        }
    }
}
