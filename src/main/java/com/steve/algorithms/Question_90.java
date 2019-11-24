package com.steve.algorithms;

import java.util.*;

/**
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Question_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, 0, nums, new Stack<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int first, int[] nums, Stack<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=first; i< nums.length; i++){
            if(i > first && nums[i] == nums[i-1])
                continue;
            temp.push(nums[i]);
            backtrack(res, i+1, nums, temp);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        Question_90 question = new Question_90();
        int[] nums1 = {1,2,2};
        System.out.println(question.subsetsWithDup(nums1));
    }

}
