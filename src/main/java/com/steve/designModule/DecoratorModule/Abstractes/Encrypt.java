package com.steve.designModule.DecoratorModule.Abstractes;

/**
 * Created by liu on 3/30/17.
 * 加密抽象类，具体构件只有一个,装饰类继承Encrypt类
 */
public abstract class Encrypt {

    //加密方法
    public abstract String encrypted(String plainWorld);

}
