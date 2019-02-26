package com.steve.designModule.StrategyModule;

import com.steve.designModule.StrategyModule.Classes.*;
import com.steve.designModule.StrategyModule.Interfaces.Aircraft;

/**
 * Created by liu on 4/8/17.
 * 策略模式
 * Sunny软件公司欲开发一款飞机模拟系统,该系统主要模拟不同种类飞机的飞行特征与起飞特
 * 征,需要模拟的飞机种类及其特征:
 *
 * 直升机(Helicopter)
 * 垂直起飞(VerticalTakeOff)
 * 亚音速飞行(SubSonicFly)
 *
 * 客机(AirPlane)
 * 长距离起飞(LongDistanceTakeOff)
 * 亚音速飞行(SubSonicFly)
 *
 * 歼击机(Fighter)
 * 长距离起飞(LongDistanceTakeOff)
 * 超音速飞行(SuperSonicFly)
 *
 * 鹞式战斗机(Harrier)
 * 垂直起飞(VerticalTakeOff)
 * 超音速飞行(SuperSonicFly)
 *
 * 为将来能够模拟更多种类的飞机,试采用策略模式设计该飞机模拟系统。
 */
public class Main {

    public static void main(String... args){
        Aircraft a1 ,a2,a3,a4;
        a1 = new Helicopter("直升机");
        a2 = new AirPlane("客机");
        a3 = new Harrier("鹞式战斗机");
        a4 = new Fighter("歼击机");
        Context context = new Context();
        context.setAircraft(a1);
        context.takeOff();
        context.fly();
        context.setAircraft(a2);
        context.fly();
        context.takeOff();
    }

}
