package com.steve.algorithms.recruit;

/**
 * 数组排序
 */
public class Question_912 {

    public static void main(String[] args) {
        Question_912 question = new Question_912();
        String[] strs = {"flight", "flow", "flower"};
        int[] sortArray = question.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        for (int arr : sortArray) {
            System.out.println(arr);
        }
    }

    /**
     * 快排实现
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int j = partition(nums, start, end);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public int partition(int[] nums, int low, int end) {
        if (low >= end) {
            return low;
        }
        int compare = nums[low];
        int i = low, j = end + 1;
        while (true) {
            while (++i <= end && nums[i] < compare) ;
            while (--j >= low && nums[j] > compare) ;
            if (i > j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[low] = nums[j];
        nums[j] = compare;
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
