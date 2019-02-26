package com.steve.designModule.AbstractFactory.Abstracts;

import com.steve.designModule.AbstractFactory.Classes.SymbianInterface;
import com.steve.designModule.AbstractFactory.Classes.SymbianOperation;
import com.steve.designModule.AbstractFactory.Interfaces.GameFactory;
import com.steve.designModule.AbstractFactory.Interfaces.InterfaceController;
import com.steve.designModule.AbstractFactory.Interfaces.OperationController;

/**
 * Created by liu on 3/26/17.
 * 负责Symbian系统的游戏软件操作
 */
public class SymbianFactory implements GameFactory {

    @Override
    public OperationController createOperation() {
        return new SymbianOperation();
    }

    @Override
    public InterfaceController createInterface() {
        return new SymbianInterface();
    }

}
