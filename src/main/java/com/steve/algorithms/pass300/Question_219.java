package com.steve.algorithms.pass300;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单:
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 */
public class Question_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i< n; i++){
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                if((i - idx) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Question_219 question = new Question_219();
        System.out.println(question.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }

}
