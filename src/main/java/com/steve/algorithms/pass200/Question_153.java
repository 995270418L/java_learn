package com.steve.algorithms.pass200;

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 */
public class Question_153 {

    public int findMin(int[] nums) {
        if(nums == null || nums.length <=0) return 0;
        int left = 0;
        int right = nums.length - 1;
        if(nums[right] >= nums[left]) return nums[left];
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) return nums[mid+1];
            if(nums[mid] <nums[mid-1]) return nums[mid];
            if(nums[mid] > nums[left]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
    

    public static void main(String[] args) {
        Question_153 question = new Question_153();

        System.out.println(question.findMin(new int[]{3,1}));
    }

}
