package com.steve.designModule.DecoratorModule.Classes;

import com.steve.designModule.DecoratorModule.Abstractes.Encrypt;

/**
 * Created by liu on 3/30/17.
 * 第一次加密
 */
public class FirstEncrypt extends Decorator {

    public FirstEncrypt(Encrypt encrypt) {
        super(encrypt);
    }

    @Override
    public String encrypted(String plainWorld) {
        super.encrypted(plainWorld);
        return first(plainWorld);
    }

    //第一次加密,反转字符串
    public String first(String plainWorld){
        StringBuilder sb = new StringBuilder();
        sb.append(plainWorld);
        return sb.reverse().toString();
    }
}
