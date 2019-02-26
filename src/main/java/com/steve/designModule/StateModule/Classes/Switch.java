package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.State;

/**
 * Created by liu on 4/8/17.
 * 环境类(转换)
 */
public class Switch {

    private static State state,onState,offState;

    private String name;  //开关名称

    public Switch(String name){
        this.name = name;
        Switch.onState = new Onstate();
        Switch.offState = new OffState();
        Switch.state = Switch.onState;
    }

    public void setState(State state){
        Switch.state = state;
    }

    public static State getState(String type){
        if(type.equalsIgnoreCase("on")){
            return new Onstate();
        }else{
            return new OffState();
        }
    }

    public void on(){
        System.out.print(name + ": ");
        state.on(this);
    }

    public void off(){
        System.out.print(name + ": ");
        state.off(this);
    }
}
