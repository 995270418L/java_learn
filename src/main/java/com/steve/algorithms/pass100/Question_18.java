package com.steve.algorithms.pass100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Question_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 3){
            return result;
        }
        Arrays.sort(nums);
        for(int k=0; k<nums.length - 3; k++){
            if(k > 0 && nums[k] == nums[k-1])
                continue;
            for(int m=k+1; m< nums.length - 2; m++) {
                if(m > k+1 && nums[m] == nums[m-1])
                    continue;
                int i=m+1, j=nums.length-1;
                while (i < j) {
                    int sum = nums[k] + nums[m] + nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[m], nums[j]));
                        while(i < j && nums[i] == nums[++i]);
                        while(i < j && nums[j] == nums[--j]);
                    } else if (sum > target) {
                        while(i < j && nums[j] == nums[--j]);
                    } else {
                        while(i < j && nums[i] == nums[++i]);
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Question_18 question = new Question_18();
        int[] nums = {0,0,0,0};
        int target = 0;
        System.out.println(question.fourSum(nums, target));
    }

}
