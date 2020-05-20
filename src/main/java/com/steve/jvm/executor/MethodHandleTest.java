package com.steve.jvm.executor;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 方法句柄的 示例, 没有使用 invokedynamic 指令，
 * 这里也可以使用反射来实现，只不过反射包含的信息太多，比较重量级，但是反射支持的功能多
 */
public class MethodHandleTest {

    public static void main(String[] args) throws Throwable {
//        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        Object obj = new ClassA();
        getPrintlnMH(obj).invokeExact("hello invoke handler world");
    }

    public static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }

    static class ClassA {
        public void println(String string) {
            System.out.println(string);
        }
    }
}
