package com.steve.designModule.BridgeModule.Classes;

import com.steve.designModule.BridgeModule.Interfaces.DataObtain;

/**
 * Created by liu on 3/28/17.
 */
public class Mysql implements DataObtain {
    @Override
    public String ObtainFromSQL()
    {
        return "Mysql" ;
    }
}
