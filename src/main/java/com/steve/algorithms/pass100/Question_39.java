package com.steve.algorithms.pass100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class Question_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> temp = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        backtracking(target, candidates, 0, temp, result);
        return result;
    }

    public void backtracking(int left, int[] candidates, int start, Stack<Integer> temp, List<List<Integer>> result){
        if(left == 0){
            result.add(new ArrayList<>(temp));
        }
        for(int i=start;  i < candidates.length && left - candidates[i] >=0; i++){
            temp.push(candidates[i]);
            backtracking(left - candidates[i], candidates, i, temp, result);
            temp.pop();                                                                    // 实现回溯的关键
        }
    }

    public static void main(String[] args) {
        Question_39 question = new Question_39();
        int[] candidate ={2,3,6,7};
        System.out.println(question.combinationSum(candidate, 7));
    }

}
