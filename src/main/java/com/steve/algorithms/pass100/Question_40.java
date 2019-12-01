package com.steve.algorithms.pass100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 */
public class Question_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> temp = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        backtracking(target, candidates, 0, temp, result);
        return result;
    }

    public void backtracking(int left, int[] candidates, int start, Stack<Integer> temp, List<List<Integer>> result){
        if(left == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;  i < candidates.length && left - candidates[i] >=0; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.push(candidates[i]);
            backtracking(left - candidates[i], candidates, i+1, temp, result);
            temp.pop();                                                                    // 实现回溯的关键
        }
    }

    public static void main(String[] args) {
        Question_40 question = new Question_40();
        int[] candidate ={10,1,2,7,6,1,5};
        System.out.println(question.combinationSum2(candidate, 8));
    }

}
