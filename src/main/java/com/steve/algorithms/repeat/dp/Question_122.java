package com.steve.algorithms.repeat.dp;


public class Question_122 {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        if( n <= 0 ) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); // 卖出股票获取利润
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]); // 买入股票减去利润
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        Question_122 question = new Question_122();
        int res = question.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(res);
    }

}
