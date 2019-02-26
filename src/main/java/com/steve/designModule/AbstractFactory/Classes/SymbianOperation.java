package com.steve.designModule.AbstractFactory.Classes;

import com.steve.designModule.AbstractFactory.Interfaces.OperationController;

/**
 * Created by liu on 3/26/17.
 * Symbian 操作控制类
 */
public class SymbianOperation implements OperationController {
    @Override
    public void display() {
        System.out.println("Symbian create OperationController");
    }
}
