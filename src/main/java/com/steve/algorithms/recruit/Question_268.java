package com.steve.algorithms.recruit;

/**
 * 1248. 统计「优美子数组」
 * <p>
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 */
public class Question_268 {


    public static void main(String[] args) {
        Question_268 question = new Question_268();
        int[] arr = {2, 4, 6};

        int target = question.numberOfSubarrays(arr, 1);  // -2147483648
        System.out.println(target);
    }

    /**
     * 双指针吧 滑动窗口实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, res = 0;
        if (n <= 0) return res;
        int i = 0, j = 0, count = 0;
        while (i < n && j < n) {
            if (nums[j] % 2 != 0) {
                count++;
            }
            if (count == k) {
                int leftOdd = 0, rightOdd = 0;
                // 找到第一个奇数的位置
                int l = i;
                for (; l < n; l++) {
                    if (nums[l] % 2 != 0) break;
                    leftOdd++;
                }
                i = l;  // i 就是第一个奇数的位置
                l = j + 1;
                for (; l < n; l++) {
                    if (nums[l] % 2 != 0) break;
                    rightOdd++;
                }
                res += (leftOdd + 1) * (rightOdd + 1);  // 可以在左边和右边一个偶数都不取
                i++;
                count--;
            }
            j++;
        }
        return res;
    }

    /**
     * 统计区间内偶数个数
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int helper(int[] nums, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] % 2 == 0) res++;
            else break;
        }
        return res;
    }

    /**
     * 统计从i位置开始，直到遇到第一个奇数，总共遇到的偶数个数
     *
     * @param nums
     * @param start
     * @return
     */
    public int end(int[] nums, int start) {
        int res = 0;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] % 2 != 0) break;
            res++;
        }
        return res;
    }

}
