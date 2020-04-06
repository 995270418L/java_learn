package com.steve.algorithms.recruit;

/**
 * 72. 编辑距离
 */
public class Question_72 {


    public static void main(String[] args) {
        Question_72 question = new Question_72();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int target = question.minDistance("horse", "ros");  // -2147483648
        System.out.println(target);
    }

    /**
     * 动态规划
     * 状态定义: dp[i][j] 表示当选择 word1【0，i】 转换成 word2【0，j】时所需的最小步数
     * 状态转移方程:
     * dp[i][j] = min(dp[i][j-1], dp[i-1][j-1], dp[i-1][j]) + 1 当且仅当 word1[i] != word2[j]. dp[i-1][j-1] 表示替换操作， dp[i-1][j] 表示删除操作， dp[i][j-1] 表示插入操作
     * 初始化状态:
     * dp[0][j] = j
     * dp[i][0] = i
     * 状态压缩 ?
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            memo[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            memo[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.min(Math.min(memo[i][j - 1], memo[i - 1][j - 1]), memo[i - 1][j]) + 1;
                }
            }
        }
        return memo[m][n];
    }

}
