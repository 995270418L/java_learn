package com.steve.designModule.ObserverModule;

import com.steve.designModule.ObserverModule.Abstracts.AllyControllCenter;
import com.steve.designModule.ObserverModule.Classes.ConcreteAllyControllCenter;
import com.steve.designModule.ObserverModule.Classes.Player;

/**
 * Created by liu on 4/7/17.
 * 观察者模式(战队信息控制中心)
 */
public class Main {

    public static void main(String... args){
        AllyControllCenter allyControllCenter = new ConcreteAllyControllCenter("天下无敌");
        Player p1,p2,p3,p4;
        p1 = new Player("杨过");
        allyControllCenter.join(p1);
        p2 = new Player("令狐冲");
        allyControllCenter.join(p2);
        p3 = new Player("张无忌");
        allyControllCenter.join(p3);
        p4 = new Player("段誉");
        allyControllCenter.join(p4);

        p1.beAttacked(allyControllCenter);
    }

}
