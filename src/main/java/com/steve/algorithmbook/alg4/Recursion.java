package com.steve.algorithmbook.alg4;

/**
 * Created by liu on 10/17/16.
 */
public class Recursion {

    public static void main(String... args){
        int a = 5;
        revise(a);
    }
    public static void revise(int a){
        if(a == 0){
            System.out.println("a == 0");
            return;
        }
        revise(--a);
        System.out.println("a = " + a);
    }
    //Conjecture result : a==0 -> a = 0 -> a = 1 -> a = 2 -> a = 3 -> a = 4 -> a = 5
    //Result : a == 0 -> a = 0 -> a = 1 -> a = 2 -> a = 3 -> a = 4
}
