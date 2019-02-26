package com.steve.designModule.FactoryMethod.Classes;

import com.steve.designModule.FactoryMethod.Interface.ImageFormat;

/**
 * Created by liu on 3/25/17.
 */
public class JpgImage implements ImageFormat {

    @Override
    public void reader() {
        System.out.println("jpg format image reader");
    }
}
