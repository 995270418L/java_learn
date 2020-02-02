package com.steve.algorithms.repeat.dp;


public class Question_309 {

    /**
     * dp[i][j][2]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0) return 0;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else if (i == 1){
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        Question_309 question = new Question_309();
        int res = question.maxProfit(new int[]{1,2,4});
        System.out.println(res);
    }

}
