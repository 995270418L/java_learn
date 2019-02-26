package com.steve.designModule.AdapterModule;

import com.steve.designModule.AdapterModule.Classes.Crypto;
import com.steve.designModule.AdapterModule.Classes.MsgAdapter;
import com.steve.designModule.AdapterModule.Interfaces.EncryMsg;

import java.security.NoSuchAlgorithmException;

/**
 * Created by liu on 3/27/17.
 */
public class Main {

    public static void main(String... args) throws NoSuchAlgorithmException {
        EncryMsg em = new MsgAdapter(new Crypto());
        String password = em.crypto("floder");
        System.out.println(password);
    }

}
