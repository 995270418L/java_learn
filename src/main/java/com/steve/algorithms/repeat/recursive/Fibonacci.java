package com.steve.algorithms.repeat.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列数列
 */
public class Fibonacci {

    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int N){
        if(N <= 1) return N;
        return fib(N-2) + fib(N-1);
    }

    /**
     * 记忆化优化提升速度
     * @param N
     * @return
     */
    public int fibMemo(int N){
        if(N <= 1) return N;
        if(map.get(N) != null) return map.get(N);
        int left = fibMemo(N - 2);
        map.put(N-2, left);
        int right = fibMemo(N-1);
        map.put(N-1, right);
        return left + right;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibMemo(10));
    }
}
