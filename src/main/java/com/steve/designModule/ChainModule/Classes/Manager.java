package com.steve.designModule.ChainModule.Classes;

import com.steve.designModule.ChainModule.Abstracts.AbstractChain;

/**
 * Created by liu on 4/2/17.
 * 经理审批类
 */
public class Manager extends AbstractChain {

    private String name;

    public Manager(String name){
        this.name = name;
    }

    @Override
    public void setLeave(Leave leave) {
        if(leave.getTime() >=3 && leave.getTime() < 10){
            System.out.println(leave.getName() + " 因为 "+ leave.getReason() + " 需要离开 "+ leave.getTime() + " 天.经理"+this.name+" 有权审批");
        }else{
            this.abstractChain.setLeave(leave);
        }
    }
}
