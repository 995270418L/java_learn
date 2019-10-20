package com.steve.algorithms;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 1，3，2 → 2,1,3
 *
 */
public class Question_31 {

    /**
     * 三步走
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i=nums.length -1;
        for(; i>0; i--){
            if(nums[i] > nums[i-1])
                break;
        }
        if(i != 0){
            // 交换 i 和 j 位置的数据
            for(int j=nums.length - 1; j > i-1; j--){
                if(nums[j] > nums[i-1]){
                    swap(nums, j, i-1);
                    break;
                }
            }
        }
        // 反向排序 i-1 后的数据
        int j= nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i ++;
            j --;
        }
    }

    public void swap(int[] nums, int start, int end){
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }

    public static void main(String[] args) {
        Question_31 question = new Question_31();
        int[] nums = {1, 3, 2};
        question.nextPermutation(nums);
        for(int i=0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }

}
