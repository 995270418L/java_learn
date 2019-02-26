package com.steve.ifeve.Reflection.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liu on 6/27/17.
 * 方法注解的反射Demo
 */
public class ReflectionAnnotationDemo {

    public static void main(String... args) throws NoSuchMethodException, NoSuchFieldException {
        Class classRef = TheAnnotationClass.class;
        // 得到所有的annotation
        Annotation[] annotations = classRef.getAnnotations();

        Method annotationMethod = classRef.getDeclaredMethod("doSomethingHere",String.class);

        // 方法注解
        // 参数为注解的类型
        Annotation annotationOfMethod = annotationMethod.getAnnotation(MyAnnotation.class);
        reflectionMethod(annotationOfMethod);

        // 获取参数的注解类型　返回的结果是一个二位数组 每一个方法的参数包含一个注解数组
        // 也就是说一个方法可能含有多个参数，每个参数和他的参数注解构成一个数组，全部的参数和参数注解构成二维数组
        Annotation[][] annotationOfMethodParameters  = annotationMethod.getParameterAnnotations();
        Class[] parameterTypes = annotationMethod.getParameterTypes();
        reflectionParameter(annotationOfMethodParameters, parameterTypes);

        //变量注解
        Field field = classRef.getDeclaredField("title");
        field.setAccessible(true);
        Annotation annotation = field.getAnnotation(MyAnnotationOfField.class);
        reflectionField(annotation);
    }

    public static void reflectionMethod(Annotation... annotations){
        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                String name = ((MyAnnotation) annotation).name();
                String value = ((MyAnnotation) annotation).value();
                System.out.println("reflectionMethod.");
                System.out.println("name: " + name + "\tvalue: " + value);
            }
        }
    }

    public static void reflectionClass(Annotation... annotations){

    }

    public static void reflectionParameter(Annotation[][] annotations, Class[] parameterTypes){
        int i = 0;
        for(Annotation[] methodParameter : annotations){
            Class parameterType = parameterTypes[i++];
            for(Annotation annotationOfparameter: methodParameter){
                if(annotationOfparameter instanceof MYAnnotationOfParameters){
                    MYAnnotationOfParameters parameters = (MYAnnotationOfParameters) annotationOfparameter;
                    System.out.println("reflectionParameter.");
                    System.out.println("name: " + parameters.name() + "\tvalue: " + parameters.value());
                }
            }
        }
    }

    public static void reflectionField(Annotation annotation){
        System.out.println("reflectionField.");
        if(annotation instanceof MyAnnotationOfField){
            MyAnnotationOfField field = (MyAnnotationOfField) annotation;
            System.out.println("name: " + field.name() + "\tvalue: " + field.value());
        }
    }

}
