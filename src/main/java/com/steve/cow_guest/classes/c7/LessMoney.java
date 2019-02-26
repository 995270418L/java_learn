package com.steve.cow_guest.classes.c7;

import java.util.PriorityQueue;

/**
 * 切金条，每切一次需要付出等价的铜币。求切金条所付出最少铜币的方案
 */
public class LessMoney {

    public static int lessMoney(int[] arr){
        if(arr == null){
            return 0;
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int a : arr){
            pQ.add(a);
        }
        int W = 0, cur;
        while (pQ.size() > 1){
            cur = (pQ.poll() + pQ.poll());
            W += cur;
            pQ.add(cur);
        }
        return W;
    }

    public static void main(String[] args) {
        System.out.println(lessMoney(new int[]{30,20,10}));
    }
}
