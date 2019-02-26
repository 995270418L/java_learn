package com.steve.designModule.CommandModule.Classes;

import com.steve.designModule.CommandModule.Abstracts.Command2;

/**
 * Created by liu on 4/3/17.
 * 具体命令类(打开命令)
 */
public class OpenCommand extends Command2 {

    @Override
    public void execute() {
        bs.open();
    }

}
