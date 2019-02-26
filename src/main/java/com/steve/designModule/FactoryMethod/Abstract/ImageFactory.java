package com.steve.designModule.FactoryMethod.Abstract;


import com.steve.designModule.FactoryMethod.Interface.ImageFormat;

/**
 * Created by liu on 3/25/17.
 */
public abstract class ImageFactory {

    //读取图片格式
    public abstract ImageFormat format();
}
