package com.steve.algorithms.repeat.dp;

public class Question_72 {

    /**
     * 编辑距离：
     *      从 word1 转换成 word2 所需最少操作。 替换，删除，插入
     * 状态定义:
     *      dp[i][j] 表示 w1[0 ... i] 变换成 w2[0 ... j] 需要的最少步数
     * 状态转移方程:
     *      如果 w1[i] == w2[j] 表示两个字符是相等的，则 dp[i][j] = dp[i-1][j-1].
     *      dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;  // dp[i-1][j-1] 表示替换单词， dp[i-1][j] 表示删除单词， dp[i][j-1] 表示插入单词
     * 状态初始化：
     *      dp[0][j] 表示空字符串转换成 word2[j] 所需最少步数, 都是插入, 所以为 j
     *      dp[i][0] 表示 word[i] 转换成空字符串所需的最少步数, 都是删除, 所以为 i
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m+1][n+1];

        for(int i=0; i<=n; i++){
            memo[0][i] = i;
        }
        for(int i=0; i<=m; i++){
            memo[i][0] = i;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1];
                }else {
                    memo[i][j] = Math.min(Math.min(memo[i - 1][j - 1], memo[i - 1][j]), memo[i][j - 1]) + 1;
                }
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        Question_72 question = new Question_72();
        System.out.println(question.minDistance("horse", "ros"));
    }

}
