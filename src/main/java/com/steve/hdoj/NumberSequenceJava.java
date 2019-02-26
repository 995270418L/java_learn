package com.steve.hdoj;

import java.util.Scanner;

/**
 * Created by liu on 10/28/16.
 */
class NumberSequenceJava {

    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(recursion(n,A,B));
        System.out.println();
    }
    public static int recursion(int n,int A, int B){
        if(n <3){
            return 1;
        }
        return (A*recursion(n-1,A,B) + B*recursion(n-2,A,B))%7;
    }
}
