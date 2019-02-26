package com.steve.grammer;

import java.util.*;

/**
 * Created by liu on 3/14/17.
 * 将一块木板分割(p47)　求开销
 */
public class FenceRepair {
    static int[] a = {5,8,8};
    static int n = 3;
    static int sum = 21;

    public static void main(String... args){
        int[] result = new int[n];
        int spent = 0;   //标记开销
        for(int i=0;i<n;i++) {
            int leave = sum - a[i];
            spent = leave * 2 + a[i];
            result[i] = spent;
        }
        Arrays.sort(result);
        System.out.println(result[0]);
    }

}
