package com.steve.designModule.FlyWeightModule.Classes;


import com.steve.designModule.FlyWeightModule.Abstractes.FlyWeight;

/**
 * Created by liu on 3/31/17.
 * 文字
 */
public class Text extends FlyWeight {

    @Override
    public String getThing() {
        return "Text";
    }
}
