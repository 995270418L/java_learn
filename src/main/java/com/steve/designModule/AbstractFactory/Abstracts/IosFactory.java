package com.steve.designModule.AbstractFactory.Abstracts;


import com.steve.designModule.AbstractFactory.Classes.IosInterface;
import com.steve.designModule.AbstractFactory.Classes.IosOperation;
import com.steve.designModule.AbstractFactory.Interfaces.GameFactory;
import com.steve.designModule.AbstractFactory.Interfaces.InterfaceController;
import com.steve.designModule.AbstractFactory.Interfaces.OperationController;

/**
 * Created by liu on 3/26/17.
 */
public class IosFactory implements GameFactory {

    @Override
    public OperationController createOperation() {
        return new IosOperation();
    }

    @Override
    public InterfaceController createInterface() {
        return new IosInterface();
    }
}
