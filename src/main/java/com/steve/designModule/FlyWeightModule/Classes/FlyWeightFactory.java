package com.steve.designModule.FlyWeightModule.Classes;


import com.steve.designModule.FlyWeightModule.Abstractes.FlyWeight;

import java.util.HashMap;

/**
 * Created by liu on 3/31/17.
 * 工厂类和单例模式结合
 */
public class FlyWeightFactory {

    private static FlyWeightFactory ff  = new FlyWeightFactory();
    private HashMap<String,FlyWeight> hm;

    private FlyWeightFactory(){
        hm = new HashMap();
        Text text = new Text();
        Pictures pic = new Pictures();
        Videos vi = new Videos();
        hm.put("t",text);
        hm.put("p",pic);
        hm.put("v",vi);
    }

    public static FlyWeightFactory getInstance() {
        return ff;
    }

    public FlyWeight getValue(String type){
        if(!hm.containsKey(type)) return null;
        return hm.get(type);
    }
}
