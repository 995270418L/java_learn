package com.steve.algorithms;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 *
 */
public class Question_34 {


    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        int left = 0;
        int right = nums.length;
        while(left < right){                        // 退出条件 left == right  寻找左侧边界算法模板
            int mid = left + (right - left) / 2 ;
            if(nums[mid] == target)
                right = mid;
            else if(nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        if (left == nums.length || nums[left] != target){  // 由于是无限逼近右侧，所以当left == nums.length 时表示为找到，所以nums[left] 最后应该停留在target的index
            return new int[]{-1, -1};
        }else{
            right = left;
            for(int i=left+1; i< nums.length; i++){
                if(nums[i] == target){
                    right = i;
                }else{
                    break;
                }
            }
            return new int[]{left, right};
        }
    }

    /**
     * 寻找右侧边界的算法
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                left = mid + 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if(left == 0)
            return -1;
        return nums[left -1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {
        Question_34 question = new Question_34();
        int[] nums = {5, 7, 7, 8, 9, 10};
        int[] new_nums = question.searchRange(nums, 8);
        for(int i=0; i< 2; i++){
            System.out.println(new_nums[i]);
        }
    }

}
