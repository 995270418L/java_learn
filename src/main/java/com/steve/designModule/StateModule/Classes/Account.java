package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.AccountState;

/**
 * Created by liu on 4/8/17.
 * 环境类 客户端主要调用入口
 */
public class Account {

    private AccountState accountState;
    private String owner;  //账户人
    private double banlance;   //金额

    public Account(String owner,double banlance){
        this.owner = owner;
        this.banlance = banlance;
        System.out.println("初始化账户成功。 账户名: " +this.owner +" 存款金额:" + this.banlance);
        accountState = new NormalState(this);
        System.out.println("----------------------------------------");
    }

    //存款
    public void deposit(double amount){
        System.out.println(this.owner + "存款; 金额: " + amount);
        accountState.deposit(amount);
        System.out.println("现在余额为:" + this.banlance);
        System.out.println("现在的状态为: " + this.accountState.getClass().getName());
        System.out.println("--------------------------------");
    }

    //取款
    public void withdraw(double amount){
        System.out.println(this.owner + " 取款; 金额: " + amount);
        accountState.withdraw(amount);
        System.out.println("现在余额为: " + this.banlance);
        System.out.println("现在的状态为: " + this.accountState.getClass().getName());
        System.out.println("-----------------------------------");
    }

    //计算利息
    public void computerInterest(){
        accountState.computInterest();
    }

    public String getOwner() {
        return owner;
    }

    public void setState(AccountState accountState){
        this.accountState = accountState;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }
}
