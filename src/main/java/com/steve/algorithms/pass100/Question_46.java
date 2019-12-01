package com.steve.algorithms.pass100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Question_46 {

    /**
     * 回溯法 (表格形式的回溯法)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        int[] visited = new int[nums.length];
        recursivePermute(nums, visited, new ArrayList<>(), res);
        return res;
    }

    /**
     * DFS
     * @param nums
     * @param visited
     * @param temp
     * @param res
     */
    public void recursivePermute(int[] nums, int[] visited, List<Integer> temp, List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i< nums.length; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            temp.add(nums[i]);
            recursivePermute(nums, visited, temp, res);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question_46 question = new Question_46();
        System.out.println(question.permute(new int[]{1,2,3}));
    }

}
