package com.steve.designModule.PrototypeModule.Classes;

import com.steve.designModule.PrototypeModule.Interfaces.OfficeDocument;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 3/26/17.
 * clone原型管理器(使用饿汉单例模式)
 */
public class PrototypeManager {
    //定义map来储存原型对象
    private Map<String,OfficeDocument> map = new HashMap();
    private static final PrototypeManager pm = new PrototypeManager();
    private PrototypeManager(){
        map.put("FAR",new FAR());
        map.put("SRS",new SRS());
    }

    public static PrototypeManager getInstance(){
        return pm;
    }

    public void addPrototype(String key,OfficeDocument od){
        map.put(key,od);
    }

    //通过潜克隆获取prototype
    public OfficeDocument getPrototype(String key){
        return map.get(key).clone();
    }
}
