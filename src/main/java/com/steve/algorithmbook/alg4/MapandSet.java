package com.steve.algorithmbook.alg4;


import java.util.HashMap;
import java.util.Map;

/*
 * Created by liu on 10/22/16.
 */
public class MapandSet {

    public void testMap(){
        Map<String,Object> testMap = new HashMap<String,Object>();
        testMap.put("name","floder");
        testMap.put("age",11);
        testMap.put("author","floder");
        //三种方法输出Map对象
        /*
        * 1. Set<keyType> keySet();
        * 2. Collection<keyType> values();
        * 3. Set<Map.Entry<keyType,valueType>> entry();
        * */
    }
}
