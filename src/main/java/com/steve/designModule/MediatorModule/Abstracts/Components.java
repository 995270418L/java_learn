package com.steve.designModule.MediatorModule.Abstracts;

/**
 * Created by liu on 4/6/17.
 */
public abstract class Components {

    private Mediator mediator;

    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }

    //转发调用
    public void change(){
        mediator.changeComponent(this);
    }

    public abstract void update();
}
