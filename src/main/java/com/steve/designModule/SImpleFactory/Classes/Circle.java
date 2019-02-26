package com.steve.designModule.SImpleFactory.Classes;

import com.steve.designModule.SImpleFactory.Abstract.Geometry;

/**
 * Created by liu on 3/25/17.
 */
public class Circle extends Geometry {

    @Override
    public void draw() {
        System.out.println("draw circle");
    }

    @Override
    public void earse() {
        System.out.println("earse circle");
    }
}
