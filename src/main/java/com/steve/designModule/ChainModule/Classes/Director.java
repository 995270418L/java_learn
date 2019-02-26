package com.steve.designModule.ChainModule.Classes;

import com.steve.designModule.ChainModule.Abstracts.AbstractChain;

/**
 * Created by liu on 4/2/17.
 * 主管
 */
public class Director extends AbstractChain {
    
    private String name;

    public Director(String name){
        this.name = name;
    }

    @Override
    public void setLeave(Leave leave) {
        if(leave.getTime() < 3 && leave.getTime() > 0){
            System.out.println(leave.getName() + " 因为　" + leave.getReason() + " 要请　"+leave.getTime() + " 假。"+ " 主任 "+this.name +"有权审批" );
        }else{
            this.abstractChain.setLeave(leave);
        }
    }
}
