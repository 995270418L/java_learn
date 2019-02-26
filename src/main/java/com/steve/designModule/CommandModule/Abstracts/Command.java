package com.steve.designModule.CommandModule.Abstracts;

/**
 * Created by liu on 4/2/17.
 * 多次撤销和恢复类
 */
public abstract class Command {

    //执行加法计算
    public abstract int execute(int value);

    //恢复(反撤销)
    public abstract int redo();

    //撤销方法(可多次撤销) 需要保存内部状态
    public abstract int undo();

}
