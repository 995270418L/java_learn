package com.steve.ifeve.multipartline.threadMethod;

/**
 * @Author: steve
 * @Date: Created in 23:10 2018/2/16
 * @Description: 饿汉式单例类
 * @Modified By:
 */
public class SingletonHungry {

    private SingletonHungry(){}

    private static SingletonHungry singletonHungry = new SingletonHungry();

    public static SingletonHungry getSingletonHungry() throws InterruptedException {
        return singletonHungry;
    }

}
