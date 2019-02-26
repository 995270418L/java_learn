package com.steve.designModule.FactoryMethod.Classes;


import com.steve.designModule.FactoryMethod.Abstract.ImageFactory;
import com.steve.designModule.FactoryMethod.Interface.ImageFormat;

/**
 * Created by liu on 3/26/17.
 */
public class GifFactory extends ImageFactory {

    //初始化该工具类
    static{
        System.out.println("初始化 GifFactory");
    }

    @Override
    public ImageFormat format() {
        return new GifImage();
    }
}
