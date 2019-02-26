package com.steve.grammer;

/**
 * Created by liu on 3/15/17.
 * 完全背包问题(即商品可重复选用)
 */
public class EntireBackpack {

    static int n = 3;
    static int w = 7;
    static int[] a_w = {3,4,2};
    static int[] b_v = {4,5,3};

    public static void main(String... args){
        res2();
    }

    //需要k
    public static void res(){
        // i:物品依次递归  j:所选物品总重量　k:物品的重复次数
        int[][] dp = new int[n+1][w+1];
        for(int i=0;i<n;i++){
            for(int j=0; j<= w;j ++){
                for(int k=0; k*a_w[i] <= j ; k++){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j- k*a_w[i]] + k *b_v[i]);
                }
            }
        }
        System.out.println(dp[n][w]);
    }

    //除去k
    public static void res2(){
        int[][] dp = new int[n+1][w+1];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<= w ; j++){
                if(j<a_w[i]){
                    dp[i+1][j] = dp[i][j];
                }else{
                    dp[i+1][j] = Math.max(dp[i][j],dp[i+1][j - a_w[i]] + b_v[i]);
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
