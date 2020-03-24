package com.steve.algorithms.recruit;

/**
 *
 * 面试题 17.16. 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 */
public class Question_1716 {

    /**
     * 动态规划。
     * 状态定义：
     *  dp[i][j] 表示在第i个序列，j种状态下的最大分钟数
     * 状态转移：
     *  j 只有两种选择， 0：不选，1：选
     *  dp[i][0] = dp[i-1][1]
     *  dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1])
     * 初始化：
     *  i = 0 的状态
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i=1; i< nums.length; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1]);
        }
        return dp[nums.length - 1][1];
    }

    public static void main(String[] args) {
        Question_1716 question = new Question_1716();
        int[] arr = {2,1,4,5,3,1,1,3};
        System.out.println(question.massage(arr));
    }

}
