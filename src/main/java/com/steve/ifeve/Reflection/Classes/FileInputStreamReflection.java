package com.steve.ifeve.Reflection.Classes;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liu on 6/26/17.
 * 这个反射包就以FileInputStream这个jdk自带的类来示例
 */
public class FileInputStreamReflection {

    public static void main(String... args) throws Exception {

        Class aClass = FileInputStream.class;
        System.out.println(aClass.getName());

        Class superAClass = aClass.getSuperclass();
        System.out.println(superAClass.getName());

        //类所属包对象
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage.getName());

        //由于一个类可以有多个接口，所以放回一个class数组
        Class[] interfaces = aClass.getInterfaces();
        for(Class bClass: interfaces){
            System.out.println(bClass.getName());
        }

        //同理,　一个类可以有多个构造函数
        Constructor[] constructors = aClass.getConstructors();
        //获取参数为String类型的构造函数
        Constructor constructor = aClass.getConstructor(new Class[]{String.class});
        // 根据constructor来实例化一个类，调用这个构造方法时需要和获取构造函数传入一样的参数类型.
        Object obejct = constructor.newInstance("demo");
        // 指定构造函数的方法参数信息
        Class[] parameters = constructor.getParameterTypes();
        for(Constructor constructord : constructors){
            System.out.println(constructord.getName());

        }


        // 获取一个类中的所有方法
        Method[] methods = aClass.getMethods();
        // 获取指定的方法 第一个参数为方法名　第二个参数为参数类型 如果没有参数则为null。
        Method methodAssign = aClass.getMethod("read", null);
        // 调用指定的方法 静态方法第一个参数则为null,非static方法则为原来方法的实例, 第二个参数需要看方法的参数类型.
        Object object = methodAssign.invoke(new FileInputStream("/home/liu/Desktop/chinese.txt"),null);
        for(Method method : methods){
            System.out.println(method.getName());
            // 获取method的返回类型
            Class classOfMethod = method.getReturnType();
            // 获取方法的参数类型
            Class[] parametersType = method.getParameterTypes();
        }


        //获取所有变量(不包括私有变量)
        Field[] fields = aClass.getFields();
        //获取指定的私有变量
        Field fieldOfPrivate = aClass.getDeclaredField("fieldOfName");
        //这行代码法会关闭指定类Field实例的反射访问检查，使得代码在哪里都可以访问(除访问域)
        fieldOfPrivate.setAccessible(true);
        //获取指定的公有变量
        Field fieldOfPublic = aClass.getField("fieldOfName");
        for(Field field : fields){
            System.out.println(field.getName());
            // 获取变量类型
            System.out.println(field.getType());
            //调用field.get()和field.set()方法为变量赋值
        }


        //获取类的注解
        Annotation[] annotations = aClass.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation.getClass().getSimpleName());
        }


    }

}
