package com.steve.ifeve.Reflection.Annotations;

/**
 * Created by liu on 6/27/17.
 */
public class TheAnnotationClass {

    @MyAnnotation
    private static void doSomethingHere(@MYAnnotationOfParameters String title){
    }

    @MyAnnotationOfField
    private String title = "title";

}
