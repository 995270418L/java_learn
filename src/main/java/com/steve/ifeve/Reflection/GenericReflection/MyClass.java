package com.steve.ifeve.Reflection.GenericReflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 6/27/17.
 * 使用泛型示例类
 */
public class MyClass {

    // 变量为泛型
    public List<String> genericList = null;
    /**
     * 方法返回类型为泛型
     * @return
     */
    public List<String> getList(){
        List<String> list  = new ArrayList<>();
        list.add("a");
        list.add("b");
        return list;
    }

    /**
     * 方法参数类型为泛型
     * @param list
     */
    public void setList(List<String> list){

    }


}