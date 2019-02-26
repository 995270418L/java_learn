package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.State;

/**
 * Created by liu on 4/8/17.
 * 开
 */
public class Onstate extends State {

    @Override
    public void on(Switch s) {
        System.out.println("已经打开");
    }

    @Override
    public void off(Switch s) {
        System.out.println("关闭");
        s.setState(Switch.getState("off"));
    }
}
