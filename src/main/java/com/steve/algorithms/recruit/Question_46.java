package com.steve.algorithms.recruit;

import java.util.ArrayList;
import java.util.List;

/**
 * 46： 全排列
 */
public class Question_46 {

    private static int ans = 0;
    private final List<List<Integer>> res = new ArrayList();

    public static void main(String[] args) {
        Question_46 question = new Question_46();
        int[] arr = {1, 1, 2, 3};
//        question.work(10,0,5,1);
//        System.out.println(ans);
        System.out.println(question.permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrace(new ArrayList(), nums, used);
        return res;
    }

    public void backtrace(List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) continue;
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtrace(list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


    public void work(int num, int i, int k, int v) {
        if (i == k) {
            ans = Math.max(ans, v);
            return;
        }
        if (num == 0) return;
        int mod = 1;
        while (num / mod != 0) {
            work(num / mod, i + 1, k, v * (num / mod));
            mod += 1;
        }
    }

}
