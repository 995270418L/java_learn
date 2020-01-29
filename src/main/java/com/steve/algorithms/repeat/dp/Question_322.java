package com.steve.algorithms.repeat.dp;


import java.util.Arrays;

/**
 * 完全背包问题
 */
public class Question_322 {

    /**
     * 初始化的时候需要注意：
     *  1: 默认数组的最小金额数量是 amount + 1;
     *  2: dp[0] 等于 0;
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 完全背包问题最优解
     *
     * 时间复杂度 O()
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
                if(wt[i-1] > j) {
                    int k = j / wt[i - 1]; // 当前背包容量最大可选数量
                    for (int m=1; m<=k; m++) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- m * wt[i-1]] + m * val[i-1]);
                    }
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][V];
    }

    /**
     * 优化时间复杂度，每次是从已经取过的物品里面取，所以是 dp[i], 而不是 dp[i-1]
     * @param wt
     * @param val
     * @param V
     * @return
     */
    public int totalPackage2(int[] wt, int[] val, int V){
        int n = wt.length;
        int[][] dp = new int[n+1][V+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=V; j++){
                if(wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][V];
    }

    /**
     * 优化空间复杂度，因为是取多次物品，所以不用倒序取，直接顺序取即可
     * @param wt
     * @param val
     * @param V
     * @return
     */
    public int totalPackage3(int[] wt, int[] val, int V){
        int n = wt.length;
        int[] dp = new int[V+1];
        for(int i=0; i<n; i++){
            for(int j=1; j<=V; j++){
                if(wt[i-1] > j) {
                    dp[j] = dp[j];
                }else{
                    dp[j] = Math.max(dp[j], dp[j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        Question_322 question = new Question_322();
        int res = question.coinChange(new int[]{1,2,5}, 11);
        System.out.println(res);
    }

}
