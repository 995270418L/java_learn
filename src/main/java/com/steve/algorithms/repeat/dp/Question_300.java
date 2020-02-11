package com.steve.algorithms.repeat.dp;

import java.util.Arrays;

public class Question_300 {

    /**
     * 状态定义：
     *     dp[i] 表示前 i 个数里面的最长子序列长度。
     *     nums[i] 表示第 i 个数的大小
     * 状态转移:
     *     两种情况 j 属于 [0, i)
     *     1: nums[i] > nums[j] 则 dp[i] = dp[j] + 1
     *     2: nums[i] <= nums[j] 则跳过
     *
     * 初始化：
     *      所有的都初始化位 1. 表示每个数字都能作为一个长度
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n <= 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Question_300 question = new Question_300();
        System.out.println(question.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

}
