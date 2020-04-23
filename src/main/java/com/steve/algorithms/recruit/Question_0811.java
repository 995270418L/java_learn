package com.steve.algorithms.recruit;

/**
 * 面试题 08.11. 硬币
 */
public class Question_0811 {

    private final int[] icon = {1, 5, 10, 25};
    private int res = 0;

    public static void main(String[] args) {
        Question_0811 question = new Question_0811();
        System.out.println(question.waysToChange(8));
    }

    /**
     * 背包问题，动态规划。
     * 状态定义: dp[i][j] 表示前 i 种硬币构成 j 面值的方案
     * 状态转移：
     * 状态初始化：dp[0][j] = 0 dp[i][0] = 0
     * 返回值： dp[i][n];
     *
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[][] dp = new int[5][n + 1];
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= j / icon[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * icon[i - 1]];
                }
            }
        }
        return dp[4][n];
    }

    public void dfs(int left) {
        if (left < 0) return;
        if (left == 0) {
            res++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (icon[i] > left) continue;
            dfs(left - icon[i]);
        }
    }


}

