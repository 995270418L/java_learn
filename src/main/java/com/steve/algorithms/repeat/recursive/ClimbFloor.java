package com.steve.algorithms.repeat.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 */
public class ClimbFloor {

    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n -2);
    }

    public int climbStairsMemo(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(map.get(n) != null) return map.get(n);
        int twoStep = climbStairs(n - 2);
        map.put(n-2, twoStep);
        int oneStep = climbStairs(n - 1);
        map.put(n-1, oneStep);
        return oneStep + twoStep;
    }

    public static void main(String[] args) {
        ClimbFloor fibonacci = new ClimbFloor();
        System.out.println(fibonacci.climbStairsMemo(10));
    }
}
