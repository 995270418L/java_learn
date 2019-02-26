package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.State;

/**
 * Created by liu on 4/8/17.
 */
public class OffState extends State {

    @Override
    public void on(Switch s) {
        System.out.println("打开");
        s.setState(Switch.getState("on"));
    }

    @Override
    public void off(Switch s) {
        System.out.println("已经关闭");
    }
}
