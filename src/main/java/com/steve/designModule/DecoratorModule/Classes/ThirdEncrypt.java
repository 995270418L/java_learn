package com.steve.designModule.DecoratorModule.Classes;

import com.steve.designModule.DecoratorModule.Abstractes.Encrypt;

import java.util.Random;

/**
 * Created by liu on 3/30/17.
 */
public class ThirdEncrypt extends Decorator {

    private static final char[] CH={'A','B','C','D','E','F','G',
                                    'H','I','J','K','L','M','N',
                                    'O','P','Q','R', 'S','T',
                                    'U','V','W','X','Y','Z'};
    private static final int LENGTH = CH.length;

    public ThirdEncrypt(Encrypt encrypt) {
        super(encrypt);
    }

    @Override
    public String encrypted(String plainWorld) {
        return super.encrypted(plainWorld);
    }

    //第三次加密(添加随机前缀加密)
    public String third(String plainWorld){
        Random random = new Random();
        char[] a = new char[8];
        //生成8位长度的字符串加密前缀
        for(int i=0;i<8;i++){
            a[i] = CH[random.nextInt(LENGTH)];
        }
        return String.valueOf(a)+plainWorld;
    }

}
