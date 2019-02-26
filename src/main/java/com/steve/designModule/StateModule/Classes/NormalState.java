package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.AccountState;

/**
 * Created by liu on 4/8/17.
 * 正常状态
 */
public class NormalState extends AccountState {

    //初始化时调用的构造函数
    public NormalState(Account account){
        this.acc = account;
    }

    //转换状态时调用的构造函数
    public NormalState(AccountState state){
        this.acc = state.acc;
    }

    //存款
    @Override
    public void deposit(double amount) {
        System.out.println("正常状态，存款金额:" + amount);
        acc.setBanlance(acc.getBanlance() + amount);
        this.checkState();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("正常状态，取款金额: " + amount);
        acc.setBanlance(acc.getBanlance() - amount);
        this.checkState();
    }

    @Override
    public void computInterest() {
        System.out.println("账户正常，不用按天计算利息");
    }

    @Override
    public void checkState() {
        double banlance = this.acc.getBanlance();
        if(banlance > -2000 && banlance < 0){
            acc.setState(new OverdraftState(this));
        }else if(banlance <= -2000){
            acc.setState(new LimitationState(this));
        }
    }
}
