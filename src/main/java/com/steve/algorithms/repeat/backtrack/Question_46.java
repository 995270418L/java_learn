package com.steve.algorithms.repeat.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 42. 接雨水
 */
public class Question_46 {

    public static void main(String[] args) {
        Question_46 question = new Question_46();
        int[] arr = {1, 2, 3};
        System.out.println(question.permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(new Stack<Integer>(), used, nums, res);
        return res;
    }

    public void dfs(Stack<Integer> cur, boolean[] used, int[] nums, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                dfs(cur, used, nums, res);
                used[i] = false;
                cur.pop();
            }
        }
    }

}
