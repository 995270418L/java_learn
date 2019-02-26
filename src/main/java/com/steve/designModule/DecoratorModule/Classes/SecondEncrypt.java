package com.steve.designModule.DecoratorModule.Classes;

import com.steve.designModule.DecoratorModule.Abstractes.Encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liu on 3/30/17.
 */
public class SecondEncrypt extends Decorator {

    public SecondEncrypt(Encrypt encrypt) {
        super(encrypt);
    }

    @Override
    public String encrypted(String plainWorld) {
        super.encrypted(plainWorld);
        return second(plainWorld);
    }

    //基于加密算法对字符串进行加密
    public String second(String plainWorld)  {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("没有此等算法");
        }
        md.update(plainWorld.getBytes());
        return md.digest().toString();
    }
}
