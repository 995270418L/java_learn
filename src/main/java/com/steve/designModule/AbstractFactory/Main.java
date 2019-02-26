package com.steve.designModule.AbstractFactory;

import com.steve.designModule.AbstractFactory.Interfaces.GameFactory;
import com.steve.designModule.AbstractFactory.Interfaces.InterfaceController;
import com.steve.designModule.AbstractFactory.Interfaces.OperationController;
import com.steve.designModule.JSONUtil;

import java.io.IOException;

/**
 * Created by liu on 3/26/17.
 */
public class Main {

    public static void main(String... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        GameFactory gf = null;
        OperationController oc = null;
        InterfaceController ic = null;
        gf = (GameFactory) JSONUtil.getBean();
        oc = gf.createOperation();
        ic = gf.createInterface();
        oc.display();
        ic.display();
    }
}
