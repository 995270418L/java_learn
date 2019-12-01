package com.steve.algorithms.pass100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Question_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, 0, nums, new Stack<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int first, int[] nums, Stack<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=first; i< nums.length; i++){
            temp.push(nums[i]);
            backtrack(res, i+1, nums, temp);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        Question_78 question = new Question_78();
        System.out.println(question.subsets(new int[]{1,2,3}));
    }

}
