package com.steve.designModule.CommandModule.Classes;

import com.steve.designModule.CommandModule.Abstracts.Command2;

/**
 * Created by liu on 4/3/17.
 */
public class EditCommand extends Command2 {

    @Override
    public void execute() {
        bs.edit();
    }
}
