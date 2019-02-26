package com.steve.designModule.ObserverModule.Interfaces;


import com.steve.designModule.ObserverModule.Abstracts.AllyControllCenter;

/**
 * Created by liu on 4/7/17.
 * 观察者(玩家)
 */
public interface Observer {

    String getName();

    void setName(String name);

    void help();

    void beAttacked(AllyControllCenter acc);
}
