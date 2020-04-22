package com.steve.algorithms.company.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        ThreeSum cm = new ThreeSum();
        System.out.println(cm.threeSum(new int[]{0, 0, 0})); // -4 -1 -1 0 1 2
    }

    /**
     * 回溯法, 解决重复数字很麻烦，使用滑动窗口 + 排序算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            add(nums, i);
        }
        return res;
    }

    public void add(int[] nums, int start) {
        int left = start + 1, right = nums.length - 1;
        List<Integer> list = new ArrayList();
        list.add(nums[start]);
        while (left < right) {
            int sum = nums[start] + nums[left] + nums[right];
            if (sum == 0) {
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(new ArrayList(list));
                list = new ArrayList();
                list.add(nums[start]);
                while (left < right && nums[left] == nums[++left]) ;
                while (left < right && nums[right] == nums[--right]) ;

            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
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
