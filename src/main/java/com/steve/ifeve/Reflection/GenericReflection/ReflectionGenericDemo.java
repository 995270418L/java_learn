package com.steve.ifeve.Reflection.GenericReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liu on 6/27/17.
 */
public class ReflectionGenericDemo {

    public static void main(String... args) throws NoSuchMethodException, NoSuchFieldException {
        Class myClass = MyClass.class;

        // 方法返回类型为泛型
        Method method = myClass.getMethod("getList",null);
        methodReturnGeneric(method);

        //方法参数类型为泛型
        Method method1 = myClass.getMethod("setList", List.class);
        methodParameterGeneric(method1);

        // 参数类型为泛型
        Field field = myClass.getField("genericList");
        fieldGeneric(field);
    }

    /**
     * 方法返回泛型
     * @param method
     */
    public static void methodReturnGeneric(Method method){
        System.out.println("methodReturnGeneric.");
        // 获取一个能正确带便object类型的类型(泛型)
        Type returnType = method.getGenericReturnType();
        //ParameterizedType:参数化的类型(泛型)
        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            // 返回这个类型的参数，有可能为0，
            Type[] typeArguements = type.getActualTypeArguments();
            for(Type typeArguement : typeArguements){
                // 将type类型的变量直接转化为Class类型.
                Class typeClass = (Class) typeArguement;
                System.out.println( "TypeClass: " + typeClass );
            }
        }
    }

    /**
     * 方法参数泛型
     * @param method
     */
    public static void methodParameterGeneric(Method method){
        System.out.println("methodParameterGeneric.");
        Type[] types = method.getGenericParameterTypes();
        for(Type type : types){
            if(type instanceof ParameterizedType){
                ParameterizedType aType = (ParameterizedType) type;
                Type[] typeArguments = aType.getActualTypeArguments();
                for(Type typeArgument : typeArguments){
                    System.out.println("TypeClass: " + typeArgument);
                }
            }
        }
    }

    /**
     * 泛型变量类型
     * @param field
     */
    public static void fieldGeneric(Field field){
        System.out.println("fieldGeneric.");
        Type type = field.getGenericType();
        if(type instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) type;
            Type[] typeArguments = aType.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                System.out.println("TypeClass: " + typeArgument);
            }
        }
    }
}
