package com.steve.designModule.StateModule.Classes;

import com.steve.designModule.StateModule.Abstracts.AccountState;

/**
 * Created by liu on 4/8/17.
 * 受限状态
 */
public class LimitationState extends AccountState {

    public LimitationState(AccountState state){
        this.acc = state.acc;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("受限状态,存款:" + amount);
        acc.setBanlance(acc.getBanlance() + amount);
        this.checkState();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("受限状态不能接受取款行为,请及时充钱");
    }

    @Override
    public void computInterest() {
        System.out.println("账户处于受限状态，按天计算利息");
    }

    @Override
    public void checkState() {
        double banlance = this.acc.getBanlance();
        if(banlance > -2000 && banlance < 0){
            this.acc.setState(new OverdraftState(this));
        }else if(banlance >= 0){
            this.acc.setState(new NormalState(this));
        }
    }
}
