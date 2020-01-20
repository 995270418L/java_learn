package com.steve.algorithms.pass300;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */
public class Question_300 {
    /**
     * 暴力枚举, 超出时间限制
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthOfLIS(int[] nums, int prev, int curpos){
        if(curpos == nums.length) return 0;
        int taken = 0;
        if(nums[curpos] > prev){
            taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
        }
        int noTaken = lengthOfLIS(nums, prev, curpos + 1);
        return Math.max(taken, noTaken);
    }

    /**
     * 动态规划优化
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    public static void main(String[] args) {
        Question_300 question = new Question_300();
        System.out.println(question.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

}
