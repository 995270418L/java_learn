package com.steve.designModule.StrategyModule.Classes;

import com.steve.designModule.StrategyModule.Interfaces.Aircraft;

/**
 * Created by liu on 4/8/17.
 */
public class AirPlane implements Aircraft {
    private String name;

    public AirPlane(String name){
        this.name = name;
    }

    @Override
    public void takeOff() {
        System.out.println(this.name + "起飞特征: 长距离起飞");
    }

    @Override
    public void fly() {
        System.out.println(this.name + "飞行特征: 亚音速起飞");
    }
}
