package com.steve.designModule.ChainModule.Abstracts;

import com.steve.designModule.ChainModule.Classes.Leave;

/**
 * Created by liu on 4/2/17.
 * 抽象链类
 */
public abstract class AbstractChain {

    protected AbstractChain abstractChain;   //维持对下一个处理类的指向

    public void setAbstractChain(AbstractChain abstractChain){
        this.abstractChain = abstractChain;
    }

    public abstract void setLeave(Leave leave);
}
