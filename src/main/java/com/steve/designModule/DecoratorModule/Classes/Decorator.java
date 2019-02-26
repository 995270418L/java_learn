package com.steve.designModule.DecoratorModule.Classes;

import com.steve.designModule.DecoratorModule.Abstractes.Encrypt;

/**
 * Created by liu on 3/30/17.
 * 装饰者
 */
public class Decorator extends Encrypt {

    private Encrypt encrypt;

    public Decorator(Encrypt encrypt){
        this.encrypt = encrypt;
    }

    @Override
    public String encrypted(String plainWorld) {
        return encrypt.encrypted(plainWorld);
    }
}
