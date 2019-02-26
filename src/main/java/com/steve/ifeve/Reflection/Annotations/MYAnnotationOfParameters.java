package com.steve.ifeve.Reflection.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liu on 6/27/17.
 * 参数型注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)

public @interface MYAnnotationOfParameters {

    String name() default "parameter";
    String value() default "null";
}
