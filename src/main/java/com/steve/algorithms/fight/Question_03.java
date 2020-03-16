package com.steve.algorithms.fight;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的重复数字
 */
public class Question_03 {

    /**
     * hash 表的实现
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums){
            if(numCount.get(num) != null) return num;
            numCount.put(num, 1);
        }
        throw new RuntimeException();
    }

    /**
     * 下标替换法, 关键词, 长度为 n 的数组里面的数字大小范围 0 ~ (n-1)
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int m = nums[i];
            if(m != i){
                if(nums[m] == m)return m;
                else{
                    nums[i] = nums[m];
                    nums[m] = m;
                }
            }
        }
        throw new RuntimeException();
    }


    public static void main(String[] args) {
        Question_03 question = new Question_03();
        System.out.println(question.findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
