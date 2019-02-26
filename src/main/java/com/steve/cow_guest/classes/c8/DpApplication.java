package com.steve.cow_guest.classes.c8;

import java.util.Arrays;

// 动态规划前世今生
public class DpApplication {

    /**
     * @param arr int数组
     * @param i   遍历到i位置
     * @param sum 遍历到i位置的和
     * @param aim 目标数据
     * @return
     */
    public static boolean isSum(int[] arr, int i, int sum, int aim){
        if(i == arr.length){
            return sum == aim;
        }
        return isSum(arr,i+1,sum+arr[i],aim) || isSum(arr,i+1,sum,aim);
    }

    public static void main(String... args){
        System.out.println(dpSum(new int[]{3,2,7,12},11));
    }

    public static boolean dpSum(int[] arr,int aim){
        int total = Arrays.stream(arr).reduce(0,Integer::sum);
        if (total < aim) {
            return false;
        }
        boolean[][] dp = new boolean[arr.length+1][total];
        for (int i=0;i < dp[0].length; i++ ){
            if(i == aim){
                dp[arr.length][i] = true;
            }
        }
        for(int i = dp.length-2 ;i >= 0; i--){
            for (int j=0 ; j < dp[0].length - arr[i] ; j++ ){
                dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
            }
        }
        return dp[0][0];
    }
}
