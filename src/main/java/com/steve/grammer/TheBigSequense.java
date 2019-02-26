package com.steve.grammer;

/**
 * Created by liu on 3/15/17.
 * LCS求最长公共子序列和的问题
 */
public class TheBigSequense {

    static int n=4;
    static int m =4;
    static String[] a={"a","b","c","d"};
    static String[] b ={"b","e","c","d"};

    public static void main(String... args){
        res();
    }

    public static void res(){
        int[][] dp = new int[n+1][m+1];   //save the length of Subsequence
        for(int i=0 ; i<n ; i++ ){
            for(int j=0 ; j<m ; j++){
                if(a[i] == b[j]){
                    dp[i+1][j+1] = dp[i][j] +1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
