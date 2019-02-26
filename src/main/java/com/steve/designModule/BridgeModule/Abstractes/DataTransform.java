package com.steve.designModule.BridgeModule.Abstractes;

import com.steve.designModule.BridgeModule.Interfaces.DataObtain;

/**
 * Created by liu on 3/28/17.
 * 数据转换抽象类
 */
public abstract class DataTransform {

    protected DataObtain dataObtain;

    public void setDateObain(DataObtain dataObtain){
        this.dataObtain = dataObtain;
    }

    public abstract void parseData(DataObtain dataObtain);
}
