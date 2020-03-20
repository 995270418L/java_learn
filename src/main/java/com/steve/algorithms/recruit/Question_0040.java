package com.steve.algorithms.recruit;

import java.util.Arrays;

/**
 *
 * 面试40: 最小的k个数
 *
 */
public class Question_0040 {

    /**
     * 快排 O(n) 的时间
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length <= 0 || k == 0) return new int[0];
        return quickSort(arr, 0, arr.length - 1,k - 1);
    }

    private int[] quickSort(int[] nums, int low, int high, int target){
        int j = partition(nums, low, high);
        if(j == target){
            return Arrays.copyOf(nums, j+1);
        }
        return j > target ? quickSort(nums, low, j-1, target) : quickSort(nums, low + 1, high, target);
    }

    private int partition(int[] nums, int low, int high){
        int transform = nums[low];
        int i = low, j = high + 1;
        while (true){
            while (++i <= high && nums[i] < transform);
            while (--j >= low && nums[j] > transform);
            if(i >= j) break;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        nums[low] = nums[j];
        nums[j] = transform;
        return j;
    }

    public static void main(String[] args) {
        Question_0040 question = new Question_0040();
        int[] arr = {0, 0, 1, 2, 4, 2 ,2, 3, 1, 4};
        int[] target = question.getLeastNumbers(arr, 8);
        for(int i : target){
            System.out.println(i);
        }
    }

}
