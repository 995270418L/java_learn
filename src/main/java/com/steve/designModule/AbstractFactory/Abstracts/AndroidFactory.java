package com.steve.designModule.AbstractFactory.Abstracts;


import com.steve.designModule.AbstractFactory.Classes.AndroidInterface;
import com.steve.designModule.AbstractFactory.Classes.AndroidOperation;
import com.steve.designModule.AbstractFactory.Interfaces.GameFactory;
import com.steve.designModule.AbstractFactory.Interfaces.InterfaceController;
import com.steve.designModule.AbstractFactory.Interfaces.OperationController;

/**
 * Created by liu on 3/26/17.
 */
public class AndroidFactory implements GameFactory {

    @Override
    public OperationController createOperation() {
        return new AndroidOperation();
    }

    @Override
    public InterfaceController createInterface() {
        return new AndroidInterface();
    }
}
