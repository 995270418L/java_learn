package com.steve.designModule.FlyWeightModule.Classes;


import com.steve.designModule.FlyWeightModule.Abstractes.FlyWeight;

/**
 * Created by liu on 3/31/17.
 */
public class Videos extends FlyWeight {

    @Override
    public String getThing() {
        return "Video";
    }

}
