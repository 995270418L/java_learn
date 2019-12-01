package com.steve.algorithms.pass100;

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 */
public class Question_81 {

    public boolean search(int[] nums, int target){
        if(nums.length <=0 ) return false;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = end - (end - start) / 2;
            if(nums[mid] == target) return true;
            if(nums[start] == nums[mid]){  // 分不清target是处于前半段或者后半段
                start ++;
            }else if (nums[start] < nums[mid]){
                // 前半段有序
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                // 后半段有序
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        if(nums.length <= 0) return false;
        int max = nums[0];
        int index = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }else{
                break;
            }
        }
        if(target <= nums[index] && target >= nums[0]){
            return binarySearch(nums,0, index, target);
        }else if(target >= nums[index+1]){
            return binarySearch(nums, index +1, nums.length - 1, target);
        }else{
            return false;
        }
    }

    public boolean binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = end - (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question_81 question = new Question_81();
        System.out.println(question.search(new int[]{5,1,3}, 3));
    }

}
