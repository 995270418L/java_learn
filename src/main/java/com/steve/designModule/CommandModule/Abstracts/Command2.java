package com.steve.designModule.CommandModule.Abstracts;

import com.steve.designModule.CommandModule.Classes.BoardScreen;

/**
 * Created by liu on 4/3/17.
 * 抽象命令类
 */
public abstract class Command2 {

    //不通过设值来获取　简单粗暴
    protected BoardScreen bs = new BoardScreen();

    public abstract void execute();

}
