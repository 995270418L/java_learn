package com.steve.designModule.ObserverModule.Classes;

import com.steve.designModule.ObserverModule.Abstracts.AllyControllCenter;
import com.steve.designModule.ObserverModule.Interfaces.Observer;

/**
 * Created by liu on 4/7/17.
 * 具体观察目标(控制中心)
 */
public class ConcreteAllyControllCenter extends AllyControllCenter {

    public ConcreteAllyControllCenter(String name){
        System.out.println(name + "创建成功");
        System.out.println("--------------------------------");
        super.allyName = name;
    }

    @Override
    public void notifyObserver(String name) {
        list.remove(name);
        for(Observer observer : list){
            if(!name.equalsIgnoreCase(observer.getName())) {
                //通知帮助
                observer.help();
            }
        }
    }

}
