package com.steve.algorithms.pass100;

/**
 * 简单:
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class Question_87 {

    /**
     * 双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前
        int p1 = m-1;
        int p2 = n-1;
        int p = m + n -1;
        while(p1 >=0 && p2 >= 0)
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }

    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        Question_87 question = new Question_87();
        int[] nums1 = {0};
        int[] nums2 = {1};
        question.merge(nums1,0, nums2, 1);
        System.out.println();
    }

}
