package com.steve.designModule.AdapterModule.Classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liu on 3/27/17.
 * 适配者:提供加密方法的第三方类库
 */
public class Crypto {

    //使用sha256加密字符串
    private static final String METHOD="sha-256";

    public  String crypto(String plainPassword) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(METHOD);
        md.update(plainPassword.getBytes());
        return new String(md.digest());
    }

}
