package com.steve.designModule.FactoryMethod.Classes;


import com.steve.designModule.FactoryMethod.Abstract.ImageFactory;
import com.steve.designModule.FactoryMethod.Interface.ImageFormat;

/**
 * Created by liu on 3/26/17.
 */
public class JpgFactory extends ImageFactory {

    static{
        System.out.println("初始化 JpgFactory");
    }
    @Override
    public ImageFormat format() {
        return new JpgImage();
    }
}
