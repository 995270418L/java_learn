package com.steve.algorithms.repeat.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂等，全组合的实现方法，包含空 List。
 * 1. 知道这个问题一共有 2 ^ len - 1 长度的结果，包含空就有 2 ^ n 个结果了
 * 2. 每个字符选或者不选，有 2 种抉择，用二进制 0 和 1 表示。
 * 3. 当每个位置的结果是 1 的时候，表示选择当前的这个字符，保存起来。否则不保存。
 * 4. 依次遍历这所有的可能结果次数， 2 ^ n - 1
 */
public class Question_0804 {

    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Question_0804 question = new Question_0804();
        List<List<Integer>> res = question.subsets2(new int[]{1, 2, 3});
        System.out.println(res);
    }

    /**
     * 位图计算，有缺陷，如果数字太大，就会超出限制。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int len = (1 << nums.length) - 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int idx = 1 << j;
                if ((i & idx) != 0) tmp.add(nums[j]);
            }
            res.add(tmp);
        }
        res.add(new ArrayList<>());
        return res;
    }

    /**
     * 回溯法实现
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrace(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 全排列问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permutation(int[] nums) {
        return null;
    }

    public void backtrack(int[] nums, int start) {
        if (start == nums.length - 1) {
//            res.add();
        }
        for (int i = start; i < nums.length; i++) {

        }
    }

    public void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

}
