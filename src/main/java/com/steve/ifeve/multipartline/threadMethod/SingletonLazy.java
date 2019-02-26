package com.steve.ifeve.multipartline.threadMethod;

/**
 * @Author: steve
 * @Date: Created in 23:14 2018/2/16
 * @Description: 懒汉式实现单例
 * @Modified By:
 */
public class SingletonLazy {

    private SingletonLazy(){}

    private static volatile SingletonLazy singletonLazy;

    public static SingletonLazy getSingletonLazy() throws InterruptedException {
        if(singletonLazy == null){
            synchronized (SingletonLazy.class){
                if(singletonLazy == null){
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }

}
