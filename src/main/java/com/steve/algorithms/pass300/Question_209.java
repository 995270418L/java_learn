package com.steve.algorithms.pass300;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */
public class Question_209 {

    /**
     * 双指针实现 O（n） 时间复杂度
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            while (sum >= s){
                res = Math.min(res, i - left + 1);
                sum -= nums[left ++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public static void main(String[] args) {
        Question_209 question = new Question_209();
        System.out.println(question.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

}
