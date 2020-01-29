package com.steve.algorithms.repeat.dp;


public class Question_123 {

    /**
     * 这次的二维数组定义 5 种不同的状态
     *
     * 0： 什么都不操作
     * 1:  第一次买入
     * 2： 第一次卖出
     * 3： 第二次买入
     * 4： 第二次卖出
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if( n <= 0 ) return 0;
        int[] dp = new int[5];
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[3] = Integer.MIN_VALUE;    // 第三种状态还没有发生，因此应该赋值为一个不可能的数
        for(int i=1; i<n; i++){
            dp[0] = Math.max(dp[0], 0);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4],  dp[3] + prices[i]);
        }
        return Math.max(dp[0], Math.max(dp[2], dp[4]));
    }

    public static void main(String[] args) {
        Question_123 question = new Question_123();
        int res = question.maxProfit(new int[]{3,3,5,0,1,4});
        System.out.println(res);
    }

}
