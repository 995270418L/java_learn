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
        if(k > (n / 2)){
            return maxProfitInf(prices);
        }
        int[][][] dp = new int[n][k+1][2];
        for(int i=0; i<n; i++){
            for(int j=1; j<=k; j++){
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]); // 持股就表示新开启了一次交易
                }
            }
        }
        return dp[n-1][k][0];
    }

    /**
     *
     * 无限次交易次数限制
     *
     * dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * 当无限交易次数的时候，k没有一个具体的值，所以可以忽略 k 的大小，实现降维
     *
     * @param prices
     * @return
     */
    public int maxProfitInf(int[] prices){
        int n = prices.length;
        if(n <= 0) return 0;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }else{
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            }
        }
        return dp[n-1][0];
    }

    /**
     * 优化上面的解法，使其变成一维数组
     * @param prices
     * @return
     */
    public int maxProfitInf_1(int[] prices){
        int n = prices.length;
        if(n <= 0) return 0;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            }
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        Question_188 question = new Question_188();
        int res = question.maxProfit(2, new int[]{3,2,6,5,0,3});
        System.out.println(res);
    }

}
