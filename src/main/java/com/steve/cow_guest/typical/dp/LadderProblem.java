package com.steve.cow_guest.typical.dp;

/**
 * @Author: steve
 * @Date: Created in 17:32 2018/3/5
 * @Description: 上阶梯问题，问上n个阶梯共有多少种方法。
 * @Modified By:
 */
public class LadderProblem {

    public static void main(String[] args) {
        int n = 10;
//        System.out.println( n + "个台阶共有 " + solve(n) + " 种方法");  89
        int[] result = new int[n + 1];   // result[n] 表示爬到n个台阶时的方法总数
        System.out.println(memorySolve(n,result));
    }

    /**
     * 暴力搜索（solve(8) 被重复计算）
     * @param n
     * @return
     */
    private static int solve(int n) {
        if(n <= 0 ){
            return 0;
        }
        if(n  == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return solve(n-1) + solve(n-2 );
    }

    private static int memorySolve(int n,int[] result){
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for(int i=3; i <= n; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

}
