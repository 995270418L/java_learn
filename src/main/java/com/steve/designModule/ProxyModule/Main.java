package com.steve.designModule.ProxyModule;

import com.steve.designModule.ProxyModule.Classes.LoggerProxy;

/**
 * Created by liu on 4/1/17.
 * 静态代理的实现
 */
public class Main {

    public static void main(String... args){
        LoggerProxy lp = new LoggerProxy();
        lp.DoMethod();
    }
}
