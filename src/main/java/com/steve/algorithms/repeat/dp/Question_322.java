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
                if(wt[i-1] < j) {
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



    public static void main(String[] args) {
        Question_322 question = new Question_322();
//        int res = question.coinChange(new int[]{2,2,6,5,4}, 33);
        int res = question.totalPackage(new int[]{2,2,6,5,4}, new int[]{1,3,4,6,7},10);
        System.out.println(res);
    }

}
