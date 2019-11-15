package com.steve.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 */
public class Question_75 {

    /**
     * 三 指针法
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int p0=0, p2 = nums.length - 1, curr=0;
        while(curr <= p2){
            if(nums[curr] == 2){
                swap(nums, curr, p2);
                p2 --;
            }else if(nums[curr] == 0){
                swap(nums, curr, p0);
                curr ++;
                p0 ++;
            }else{
                curr ++;
            }
        }
        System.out.println();
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.get(num) != null){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        int index = 0;
        for(int i=0; i<3; i++){
            for(int j=map.get(i); j>0; j --){
                nums[index ++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Question_75 question = new Question_75();
        question.sortColors(new int[]{2,0,1});
    }

}
