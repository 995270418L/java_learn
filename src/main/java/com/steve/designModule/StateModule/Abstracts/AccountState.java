package com.steve.designModule.StateModule.Abstracts;

import com.steve.designModule.StateModule.Classes.Account;

/**
 * Created by liu on 4/8/17.
 */
public abstract class AccountState {

    public Account acc;

    public abstract void deposit(double amount);   //存款

    public abstract void withdraw(double amount);   //取款

    public abstract void computInterest();   //计算利息

    public abstract void checkState();    //检查状态
}
