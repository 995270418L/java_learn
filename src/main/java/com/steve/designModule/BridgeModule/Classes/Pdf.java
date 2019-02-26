package com.steve.designModule.BridgeModule.Classes;


import com.steve.designModule.BridgeModule.Abstractes.DataTransform;
import com.steve.designModule.BridgeModule.Interfaces.DataObtain;

/**
 * Created by liu on 3/28/17.
 */
public class Pdf extends DataTransform {
    @Override
    public void parseData(DataObtain dataObtain) {
        System.out.println("transform the "+dataObtain.ObtainFromSQL()+" data into pdf format");
    }
}
