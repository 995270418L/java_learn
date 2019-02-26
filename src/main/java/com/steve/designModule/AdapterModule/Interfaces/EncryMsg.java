package com.steve.designModule.AdapterModule.Interfaces;

import java.security.NoSuchAlgorithmException;

/**
 * Created by liu on 3/27/17.
 * 加密信息接口
 */
public interface EncryMsg {

    String crypto(String plainPassword) throws NoSuchAlgorithmException;

}
