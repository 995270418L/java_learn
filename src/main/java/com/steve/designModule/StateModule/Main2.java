package com.steve.designModule.StateModule;

import com.steve.designModule.StateModule.Classes.Switch;

/**
 * Created by liu on 4/8/17.
 * 共享状态(开关)
 */
public class Main2 {

    public static void main(String... args){
        Switch a ,b;
        a = new Switch("开关1");
        b = new Switch("开关2");
        a.on();
        b.on();
        a.off();
        b.off();
        b.on();
        a.on();
    }
}
