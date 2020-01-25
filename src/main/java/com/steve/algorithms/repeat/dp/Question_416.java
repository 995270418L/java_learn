package com.steve.algorithms.repeat.dp;


public class Question_416 {

    public boolean canPartition(int[] nums) {

        return false;
    }

    /**
     * 0 - 1 背包问题
     * @param V 背包的总容量
     * @param c 每个物品占用的容量数组
     * @param v 每个物品的价值数组
     * @return
     * 1.
     *  dp[i][j] 表示前 i 件物品放入容量为j的背包的总价值最大
     * 2.
     *  dp[i][j] = Math.max(dp[i-1][j], dp[i-1][V-c[i]] + v[i])  // 不放入 i 件物品,空间占用沿用上一个的，容量也是 j，放入第 i 件物品， 剩余容量 V- c[i] 的背包中，
     *  此时的最大价值是 dp[i-1][V - c[i]] 和 v[i] 的和
     *
     * 3.
     *  空间压缩
     *  V
     *
     *
     */
    public int packageZeroToOne(int V, int[] c, int[] v) {
        int size = v.length;
        int[][] dp = new int[size + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= V; j++) {
                if (c[i-1] > j) {
                    dp[i][j] = dp[i - 1][j];  // 不放入这个物品
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i-1]] + v[i-1]);
                }
            }
        }
        return dp[size][V];
    }

    public int packageZeroToOne2(int V, int[] c, int[] v) {
        int size = v.length;
        int[] dp = new int[V+1];
        for (int i = 1; i <= size; i++) {
            for (int j = V; j > 0; j--) {
                if (c[i - 1] > j) {
                    dp[j] = dp[j-1];  // 不放入这个物品
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j - c[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        Question_416 question = new Question_416();
        int res = question.packageZeroToOne2(10, new int[]{2,2,6,5,4}, new int[]{6,3,5,4,6});
        System.out.println(res);
    }

}
