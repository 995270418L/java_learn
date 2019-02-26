package com.steve.designModule.StateModule.Abstracts;

import com.steve.designModule.StateModule.Classes.Switch;

/**
 * Created by liu on 4/8/17.
 * 开关状态　 on or off
 */
public abstract class State {

    public abstract void on(Switch s);

    public abstract void off(Switch s);
}
