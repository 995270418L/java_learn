package com.steve.designModule.StrategyModule.Classes;

import com.steve.designModule.StrategyModule.Interfaces.Aircraft;

/**
 * Created by liu on 4/8/17.
 * 环境类
 */
public class Context {
    private Aircraft aircraft;

    public void setAircraft(Aircraft aircraft){
        this.aircraft = aircraft;
    }

    //起飞特征
    public void takeOff(){
        aircraft.takeOff();
    }

    //飞行特征
    public void fly(){
        aircraft.fly();
    }
}
