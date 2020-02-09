package com.steve.algorithms.repeat.dp;


public class Question_121 {

    /**
     *
     * 1: 状态定义
     *  dp[i][j] 表示在手上持股为 i 的这一天， 股票状态为 j 所获得的最大利润
     *
     * 2: 转移方程：
     *  1). dp[i][0] 表示第 i 天不持股，前一天有两种可能，   dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
     *  2). dp[i][1] 表示第 i 天持股， 前一天也有两种可能， dp[i][1] = Math.max(dp[i-1][1], -prices[i])
     *
     * 3: 考虑初始值：
     *  dp[0][0] = 0, dp[0][1] = -prices[0]
     *
     * 4: 考虑输出
     *  dp[n][0]
     *
     * 5: 状态压缩
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]); // 这里买入股票时都是前面的状态清零的.
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        Question_121 question = new Question_121();
        int res = question.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(res);
    }

}
