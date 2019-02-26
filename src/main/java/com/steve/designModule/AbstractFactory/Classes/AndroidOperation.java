package com.steve.designModule.AbstractFactory.Classes;

import com.steve.designModule.AbstractFactory.Interfaces.OperationController;

/**
 * Created by liu on 3/26/17.
 */
public class AndroidOperation implements OperationController {
    @Override
    public void display() {
        System.out.println("Android create OperationController");
    }
}
