package com.steve.ifeve.Reflection.DynamicReflection;

/**
 * Created by liu on 6/27/17.
 * 测试使用MyClassLoader
 */
public class MyClass {

    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //父类加载器 因为加载一个类是从它的父类加载器开始加载，所以获得的类加载器即父类加载器。
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        Class myObjectClass = classLoader.loadClass("Main");
        AnInterface2 object1 = (AnInterface2) myObjectClass.newInstance();
        MyObjectSupperClass object2 = (MyObjectSupperClass) myObjectClass.newInstance();

        // create new class loader so classes can be reloaded.（重载）
        classLoader = new MyClassLoader(parentClassLoader);
        myObjectClass = classLoader.loadClass("Main");
        object1 = (AnInterface2) myObjectClass.newInstance();
        object2 = (MyObjectSupperClass) myObjectClass.newInstance();

    }
}
