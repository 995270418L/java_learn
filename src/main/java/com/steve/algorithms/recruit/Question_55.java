package com.steve.algorithms.recruit;

/**
 * 面试题13. 机器人的运动范围
 */
public class Question_55 {

    public static void main(String[] args) {
        Question_55 question = new Question_55();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(question.merge(new int[]{3, 2, 1, 0, 4}));  // 16, 8, 4
    }

    /**
     * 很简单的贪心，加点 记忆化功能
     * 状态定义， dp[i] 表示第 i 个数字能到达终点。
     * 状态转移：
     * dp[i] = dp[i for i + nums[i]] is true  前的状态依赖于后面的状态
     *
     * @param nums
     * @return
     */
    public boolean merge(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        boolean[] dp = new boolean[n];
        if (nums[n - 1] >= 0) dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int num = nums[i];
            for (int j = 1; j <= num; j++) {
                int idx = i + j;
                if (idx >= n) break;
                if (dp[idx]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
