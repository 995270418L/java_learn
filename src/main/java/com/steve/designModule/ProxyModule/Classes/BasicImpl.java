package com.steve.designModule.ProxyModule.Classes;

import com.steve.designModule.ProxyModule.Abstracts.BasicClass;

import java.lang.reflect.Method;

/**
 * Created by liu on 4/1/17.
 * 正常继承对象　也就是被代理的对象
 */
public class BasicImpl implements BasicClass {

    /**
     * 减法
     * @return
     */
    public String subTraction(){
        return "subtraction";
    }

    /**
     * 加法
     * @return
     */
    public String add(){
        return "add";
    }

    @Override
    public String DoMethod() {
        return subTraction();
    }

}
