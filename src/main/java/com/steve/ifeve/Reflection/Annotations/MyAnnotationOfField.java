package com.steve.ifeve.Reflection.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liu on 6/27/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface MyAnnotationOfField {

    String name() default "Field";
    String value() default "null value";
}
