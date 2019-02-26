package com.steve.designModule.ChainModule.Classes;


import com.steve.designModule.ChainModule.Abstracts.AbstractChain;

/**
 * Created by liu on 4/2/17.
 * 总经理
 */
public class GeneralManager extends AbstractChain {

    private String name;

    public GeneralManager(String name){
        this.name = name;
    }

    @Override
    public void setLeave(Leave leave) {
        if(leave.getTime() >= 10 && leave.getTime() < 30){
            System.out.println(leave.getName() + " 因为 "+ leave.getReason() + " 需要离开 "+leave.getTime()+" 天。总经理"+this.name+" 有权审批");
        }else{
            System.out.println("你需要离开这么久，那不如离职吧!");
        }
    }
}
