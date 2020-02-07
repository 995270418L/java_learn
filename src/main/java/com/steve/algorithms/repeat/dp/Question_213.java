package com.steve.algorithms.repeat.dp;


public class Question_213 {

    /**
     * 环状偷家, 可以分为两种情况讨论, 一种把第一个房间加入计算，最后一个房间去除计算，一种把第一个房间去除，最后一个房保留计算
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        return Math.max(robN(nums, 1, nums.length), robN(nums, 0, nums.length - 1));
    }

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
     *      i == n - 1
     *
     * @param nums
     * @return
     */
    public int robN(int[] nums, int start, int end) {
        int[] dp = new int[end];
        for(int i=start; i<end; i++){
            if(i == start){
                dp[i] = nums[start];
            }else if(i == (start + 1)){
                dp[i] = Math.max(dp[i-1], nums[i]);
            }else{
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        return nums.length == 1 ? nums[0] : dp[end - 1];
    }

    public static void main(String[] args) {
        Question_213 question = new Question_213();
        int res = question.rob(new int[]{0});
        System.out.println(res);
    }

}
