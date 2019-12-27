package com.steve.algorithms.pass200;

/**
 * 简单：
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 */
public class Question_189 {

    /**
     * 暴力替换法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int temp, prev = 0;
        for(int i=1; i<=k; i++){
            prev = nums[nums.length - 1];
            for(int j=0; j<nums.length; j++){
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
        System.out.println();
    }

    /**
     * 加数组法
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int index = (i + k) % nums.length;
            newNums[index] = nums[i];
        }
        for(int i=0;i<nums.length; i++){
            nums[i] = newNums[i];
        }
    }

    public static void main(String[] args) {
        Question_189 question = new Question_189();
        question.rotate2(new int[]{1,2,3,4,5,6,7}, 3);
        System.out.println();
    }

}
