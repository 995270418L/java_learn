package com.steve.algorithms.repeat.dp;


public class Question_188 {

    /**
     *
     * 填表法就是把每一个物品的每一次可能的状态变更都填充进来。
     *
     * 状态定义：
     *  dp[i][j] 表示第 i 天，状态为 j 所对应的最大的利润
     *
     * 状态转移:
     *  dp[i][j]
     *
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n <= 0) return 0;
        // 三种状态 0 为不持股， 1 为持股
        int[][][] dp = new int[n][k][2];
        // 初始化
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        for(int i=1; i<k; i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
            }
        }
        return dp[n-1][k-1][0];
    }

    public static void main(String[] args) {
        Question_188 question = new Question_188();
        int res = question.maxProfit(2, new int[]{2,4,1});
        System.out.println(res);
    }

}
