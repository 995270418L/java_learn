package com.steve.designModule.AbstractFactory.Classes;


import com.steve.designModule.AbstractFactory.Interfaces.InterfaceController;

/**
 * Created by liu on 3/26/17.
 */
public class AndroidInterface implements InterfaceController {
    @Override
    public void display() {
        System.out.println("Android create InterfaceController");
    }
}
