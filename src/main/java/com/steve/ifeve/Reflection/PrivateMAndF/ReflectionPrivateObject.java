package com.steve.ifeve.Reflection.PrivateMAndF;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liu on 6/27/17.
 * 反射私有对象的类和方法
 */
public class ReflectionPrivateObject {

    /**
     * 获取私有参数值
     * @param args
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
//    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
//        PrivateObject privateObject = new PrivateObject("demo");
//        Class<PrivateObject> object = PrivateObject.class;
//        // 获取私有方法
//        Field fieldOfPrivate = object.getDeclaredField("args");
//        fieldOfPrivate.setAccessible(true);
//
//        String fieldValue = (String) fieldOfPrivate.get(privateObject);
//        System.out.println(fieldValue);
//    }

    public static void main(String... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PrivateObject privateObject = new PrivateObject("demo");
        // 反射获取对象
        Class object = PrivateObject.class;
        Method methodOfPrivate = object.getDeclaredMethod("getArgs");

        methodOfPrivate.setAccessible(true);

        String methodfReturnValue = (String) methodOfPrivate.invoke(privateObject,null);
        System.out.println(methodfReturnValue);
    }
}
