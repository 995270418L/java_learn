package com.steve.designModule.FlyWeightModule.Classes;


import com.steve.designModule.FlyWeightModule.Abstractes.FlyWeight;

/**
 * Created by liu on 3/31/17.
 * 图片
 */
public class Pictures extends FlyWeight {

    @Override
    public String getThing() {
        return "Pictures";
    }
}
