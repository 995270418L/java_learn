package com.steve.ifeve.Reflection.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liu on 6/27/17.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {

    String name() default "liu";
    String value() default "steve";

}
