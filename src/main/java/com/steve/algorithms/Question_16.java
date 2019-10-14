package com.steve.algorithms;


import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class Question_16 {

    /**
     * 排序 + 双指针。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for(int k=0; k < nums.length; k++){
            int i=k+1, j=len -1;
            if(nums[k] > Math.abs(minDiff))
                break;
            if(k > 0 && nums[k] == nums[k-1])
                continue;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                int diff = Math.abs(sum - target);
                if(diff < Math.abs(minDiff)){
                    res = sum;
                    minDiff = diff;
                }
                j --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question_16 q = new Question_16();
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println(q.threeSumClosest(nums, target));
    }

}
