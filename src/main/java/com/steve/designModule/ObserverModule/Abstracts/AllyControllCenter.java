package com.steve.designModule.ObserverModule.Abstracts;


import com.steve.designModule.ObserverModule.Interfaces.Observer;

import java.util.ArrayList;

/**
 * Created by liu on 4/7/17.
 * 观察目标(控制中心)
 */
public abstract class AllyControllCenter {

    protected String allyName;   // 战队名称

    protected ArrayList<Observer> list = new ArrayList<>();    //所有战队成员

    public void join(Observer observer){
        System.out.println("欢迎:" + observer.getName()+"加入"+allyName);
        list.add(observer);
    }

    public void remove(Observer observer){
        System.out.println(observer.getName() + "退出"+allyName);
        list.remove(observer.getName());
    }

    //抽象方法通知其他成员调用help方法
    public abstract void notifyObserver(String name);

}

