package com.steve.designModule.BridgeModule.Classes;


import com.steve.designModule.BridgeModule.Abstractes.DataTransform;
import com.steve.designModule.BridgeModule.Interfaces.DataObtain;

/**
 * Created by liu on 3/28/17.
 * 获取数据并转换为txt格式
 */
public class Txt extends DataTransform {

    @Override
    public void parseData(DataObtain dataObtain) {
        System.out.println("transform the "+dataObtain.ObtainFromSQL()+" data into txt format");
    }

}
