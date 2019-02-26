package com.steve.designModule.ObserverModule.Classes;


import com.steve.designModule.ObserverModule.Abstracts.AllyControllCenter;
import com.steve.designModule.ObserverModule.Interfaces.Observer;

/**
 * Created by liu on 4/7/17.
 */
public class Player implements Observer {

    private String name;

    public Player(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    //接受到求救请求
    @Override
    public void help() {
        System.out.println("坚持住," + this.name + "马上来救你!");
    }

    //被攻击
    @Override
    public void beAttacked(AllyControllCenter acc) {
        System.out.println("不好,"+ this.name + "正在被攻击,请求支援!");
        acc.notifyObserver(this.name);
    }
}
