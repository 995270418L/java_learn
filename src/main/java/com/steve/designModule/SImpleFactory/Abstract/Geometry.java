package com.steve.designModule.SImpleFactory.Abstract;

import com.steve.designModule.SImpleFactory.Classes.Circle;
import com.steve.designModule.SImpleFactory.Classes.Square;
import com.steve.designModule.SImpleFactory.Classes.Trigon;
import com.steve.designModule.SImpleFactory.Classes.UnsupportedShapeException;

/**
 * Created by liu on 3/25/17.
 */
public abstract class Geometry {

    //抽象方法
    public abstract void draw();

    public abstract void earse();

    public static Geometry createFactory(String argv) throws UnsupportedShapeException {
        if(argv.equals("circle")){
            return new Circle();
        }else if(argv.equals("square")){
            return new Square();
        }else if(argv.equals("trigon")){
            return new Trigon();
        }else{
            throw new UnsupportedShapeException();
        }
    }

}
