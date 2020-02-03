package com.steve.algorithms.repeat.dp;


public class Question_198 {

    /**
     * 1. 状态定义：
     *      dp[i][j] 表示在第 i 个房间处于 j 的状态下的最大收入
     *      j 共有两种选择： 0：偷 1：不偷
     * 2. 状态转移:
     *      第 i 间房间选择偷， 则最大的收入来自于上一个房间不偷 + 这个房间 偷
     *      第 i 个房间不选择偷，最大的收入来自于上一个房间偷
     *      dp[i][0] = Math.max(dp[i-1][1], dp[i-2][0] + nums[i])
     *      dp[i][1] = Math.max(dp[i-1][])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Question_198 question = new Question_198();
        int res = question.rob(new int[]{2,7,9,3,1});
        System.out.println(res);
    }

}
