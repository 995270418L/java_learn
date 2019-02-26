package com.steve.designModule.CommandModule;


import com.steve.designModule.CommandModule.Abstracts.Command;
import com.steve.designModule.CommandModule.Classes.CanculatorForm;
import com.steve.designModule.CommandModule.Classes.ConcreteAdder;

/**
 * Created by liu on 4/2/17.
 * 命令行模式练习1
 */
public class Main {

    public static void main(String... args){
        CanculatorForm cf ;
        Command cd1;
        cf = new CanculatorForm();
        cd1 = new ConcreteAdder();
        cf.setCommand(cd1);
        cf.canculator(5);
        cf.canculator(10);
        cf.canculator(15);
        cf.undo();
        cf.undo();
        cf.redo();
    }
}
