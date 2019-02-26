package com.steve.designModule.SImpleFactory;


import com.steve.designModule.SImpleFactory.Abstract.Geometry;
import com.steve.designModule.SImpleFactory.Classes.UnsupportedShapeException;

/**
 * Created by liu on 3/25/17.
 */
public class Main {
    public static void main(String... args) throws UnsupportedShapeException {
        Geometry ge = Geometry.createFactory("circle");
        ge.draw();
        ge.earse();
        Geometry ge2 = Geometry.createFactory("ssss");
        ge2.draw();
        ge2.earse();
    }
}
