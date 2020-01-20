package com.steve.algorithms.pass300;


/**
 *
 *给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class Question_279 {

    /**
     *  dp[i] 表示到组成 i 个数据的最小的数字和
     *  dp[i] = Math.min(dp[i], dp[i - j*j] + 1) // j 表示 1 => j 的最大数字和
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i=1; i<=n ;i++){
            dp[i] = i;
            for(int j=1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question_279 question = new Question_279();
        System.out.println(question.numSquares(13));
    }

}
