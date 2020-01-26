package com.steve.algorithms.repeat.dp;


/**
 * 完全背包问题
 */
public class Question_322 {

    public int coinChange(int[] coins, int amount) {
        return 0;
    }

    /**
     * 完全背包问题最优解
     * @param wt
     * @param val
     * @param V
     * @return
     */
    public int totalPackage(int[] wt, int[] val, int V){
        int n = wt.length;
        int[][] dp = new int[n+1][V+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=V; j++){

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Question_322 question = new Question_322();
        int res = question.coinChange(new int[]{2,2,6,5,4}, 33);
        System.out.println(res);
    }

}
