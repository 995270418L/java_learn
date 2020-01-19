package com.steve.algorithms.pass300;


import java.util.HashSet;
import java.util.Set;

/**
 * 简单:
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 */
public class Question_268 {

    /**
     * 使用 O（n） 的空间
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int numCount = nums.length;
        for(int i=0; i<= numCount; i++){
            if(!set.contains(i)) return i;
        }
        return 0;
    }

    /**
     * 0 异或任何数都是任何数
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for(int i=0; i<nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 高斯定理
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }

    public static void main(String[] args) {
        Question_268 question = new Question_268();
        System.out.println(question.missingNumber3(new int[]{3, 0, 1}));
    }

}
