package com.steve.designModule.FlyWeightModule.Abstractes;


import com.steve.designModule.FlyWeightModule.Classes.Location;
import com.steve.designModule.FlyWeightModule.Classes.Size;

/**
 * Created by liu on 3/31/17.
 * 亨元抽象类
 */
public abstract class FlyWeight {

    public abstract String getThing();

    public void display(Location loc, Size size){
        System.out.println("This is: "+ this.getThing()+" Size: " +
                            size.getSize() + " Location x: " + loc.getX() +
                            " Location y: " + loc.getY());
    }

}
