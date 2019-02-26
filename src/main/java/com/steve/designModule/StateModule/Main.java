package com.steve.designModule.StateModule;

import com.steve.designModule.StateModule.Classes.Account;

/**
 * Created by liu on 4/8/17.
 * 状态模式(银行账户状态: 正常，透支，受限)
 */
public class Main {

    public static void main(String... args){
        Account acc = new Account("floder",0);
        acc.deposit(2000);
        acc.withdraw(4000);
        acc.withdraw(4000);
        acc.deposit(7000);
    }
}
