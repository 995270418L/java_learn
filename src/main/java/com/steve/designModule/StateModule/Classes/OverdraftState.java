package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.AccountState;

/**
 * Created by liu on 4/8/17.
 * 透支状态
 */
public class OverdraftState extends AccountState {

    public OverdraftState(AccountState state){
        this.acc = state.acc;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("透支状态，存款:" + amount);
        acc.setBanlance(acc.getBanlance() + amount);
        checkState();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("透支状态，取款: " + amount);
        acc.setBanlance(acc.getBanlance() - amount);
        checkState();
    }

    @Override
    public void computInterest() {
        System.out.println("账户处于透支状态，按天计算利息");
    }

    @Override
    public void checkState() {
        double banlance = this.acc.getBanlance();
        if(banlance >= 0){
            acc.setState(new NormalState(this));
        }else if(banlance <= -2000){
            acc.setState(new LimitationState(this));
        }
    }
}
