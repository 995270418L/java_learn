package com.steve.grammer;

import java.util.Scanner;

/**
 * Created by liu on 3/13/17.
 * 判断所给数组能否找到和和K相等的，返回true or false
 */
public class judge {

    static int n = 4;
    static int k = 13;
    static int[] a = {1,2,4,7};
    public static void main(String... args){

        boolean  result = dfs(0,0);
        System.out.println(result);
    }

    public static boolean dfs(int i, int sum){
        if(i == n){
            return sum == k;   //当执行到底部的时候，判断是否和要求的结果相同
        }
        //加上a[i],看结果
        if(dfs(i+1,sum+a[i])) return true;

        //不加上a[i],看结果
        if(dfs(i+1,sum)) return true;


        return false;
    }
}
