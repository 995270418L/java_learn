package com.steve.algorithms.repeat.dp;


public class Question_518 {

    /**
     * 输出有多少种方法可以得到这个 amount
     *  状态转移方程:
     *      dp[j] = dp[j] + dp[j-coins[i]]
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            for(int j=1; j<=amount; j++){
                if(j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Question_518 question = new Question_518();
        int res = question.change(3, new int[]{2});
        System.out.println(res);
    }

}
