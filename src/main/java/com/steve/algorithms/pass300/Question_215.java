package com.steve.algorithms.pass300;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
public class Question_215 {

    /**
     * 先排序，后取值 O（NlogN）
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 大顶堆 O(Nlogk)，这个堆太麻烦了，但是省空间
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        Question_215 question = new Question_215();
        System.out.println(question.findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
    }

}
