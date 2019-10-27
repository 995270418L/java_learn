package com.steve.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class Question_47 {

    /**
     * 回溯法 (表格形式的回溯法)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
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
            if(i >0 && nums[i] == nums[i-1] && visited[i-1] == 1) continue;  // 如果当前数的前一个数也使用过，并且当前数和前一个数相等，则跳过当前数
            visited[i] = 1;
            temp.add(nums[i]);
            recursivePermute(nums, visited, temp, res);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question_47 question = new Question_47();
        System.out.println(question.permuteUnique(new int[]{1,1,2}));
    }

}
