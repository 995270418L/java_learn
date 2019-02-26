package com.steve.designModule.BridgeModule;

import com.steve.designModule.BridgeModule.Abstractes.DataTransform;
import com.steve.designModule.BridgeModule.Classes.Mysql;
import com.steve.designModule.BridgeModule.Classes.Txt;
import com.steve.designModule.BridgeModule.Interfaces.DataObtain;

/**
 * Created by liu on 3/28/17.
 *    Sunny软件公司欲开发一个数据转换工具,可以将数据库中的数据转换成多种文件格式,
 * 例如txt、xml、pdf等格式,同时该工具需要支持多种不同的数据库。试使用桥接模式对
 * 其进行设计。
 */
public class Main {

    public static void main(String... args){
        DataTransform df ;
        DataObtain dataObtain ;
        dataObtain = new Mysql();
        df = new Txt();
        df.setDateObain(dataObtain);
        df.parseData(dataObtain);
    }

}
