package com.steve.designModule.AdapterModule.Classes;

import com.steve.designModule.AdapterModule.Interfaces.EncryMsg;

import java.security.NoSuchAlgorithmException;

/**
 * Created by liu on 3/27/17.
 * 适配器类
 */
public class MsgAdapter implements EncryMsg {

    private Crypto crypto;

    public MsgAdapter(Crypto crypto){
        this.crypto = crypto;
    }

    @Override
    public String crypto(String plainPassword) throws NoSuchAlgorithmException {
        return crypto.crypto(plainPassword);
    }

}
