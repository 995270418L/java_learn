package com.steve.ifeve.Reflection.PrivateMAndF;

/**
 * Created by liu on 6/27/17.
 * 这个示例类用来学习　私有方法和参数的反射
 */
public class PrivateObject {

    private String args = null;

    public PrivateObject(String args){
        this.args = args;
    }

    private String getArgs(){
        return this.args;
    }
}
