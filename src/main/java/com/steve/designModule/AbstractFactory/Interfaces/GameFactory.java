package com.steve.designModule.AbstractFactory.Interfaces;

/**
 * Created by liu on 3/26/17.
 */
public interface GameFactory {

    //游戏操作类
    OperationController createOperation();

    //界面控制类
    InterfaceController createInterface();
}
