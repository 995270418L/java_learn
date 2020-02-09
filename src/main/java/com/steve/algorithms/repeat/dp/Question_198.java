package com.steve.algorithms.repeat.dp;


public class Question_198 {

    /**
     * 1. 状态定义：
     *      dp[i][j] 表示在第 i 个房间处于 j 的状态下的最大收入
     *      j 共有两种选择： 0：偷 1：不偷。
     *
     *      在不偷的情况下，最大收入就是前一天偷了的收入。所以状态只有一种。所以变成了 dp[i]。
     * 2. 状态转移:
     *      dp[0] = nums[0]
     *      dp[1] = Math.max(dp[0], nums[1])
     *      dp[2] = Math.max(dp[i-1], dp[i-2] + nums[i])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 0) return 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            if(i == 0){
                dp[i] = nums[i];
            }else if(i == 1){
                dp[i] = Math.max(dp[i-1], nums[i]);
            }else{
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Question_198 question = new Question_198();
        int res = question.rob(new int[]{2, 3, 3, 3, 1});
        System.out.println(res);
    }

}
