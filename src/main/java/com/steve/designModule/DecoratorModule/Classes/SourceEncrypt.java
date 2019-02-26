package com.steve.designModule.DecoratorModule.Classes;

import com.steve.designModule.DecoratorModule.Abstractes.Encrypt;

/**
 * Created by liu on 3/30/17.
 */
public class SourceEncrypt extends Encrypt {
    @Override
    public String encrypted(String plainWorld) {
        return plainWorld;
    }
}
