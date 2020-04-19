package com.steve.algorithms.company.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        ThreeSum cm = new ThreeSum();
        System.out.println(cm.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        backtrace(new ArrayList<>(), 0, 0, nums);
        return res;
    }


    public void backtrace(List<Integer> tmp, int start, int sum, int[] nums) {
        if (sum == 0 && tmp.size() == 3) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (tmp.size() >= 3 || start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1] && tmp.size() == 0) continue;
            }
            tmp.add(nums[i]);
            sum += nums[i];
            backtrace(tmp, i + 1, sum, nums); // 如果这里是 start + 1 就会出现递归返回数据重复的效果
            int remove = tmp.get(tmp.size() - 1);
            sum -= remove;
            tmp.remove(tmp.size() - 1);
        }
    }

}
