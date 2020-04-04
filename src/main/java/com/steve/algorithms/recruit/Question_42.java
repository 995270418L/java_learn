package com.steve.algorithms.recruit;

/**
 * 42. 接雨水
 */
public class Question_42 {

    public static void main(String[] args) {
        Question_42 question = new Question_42();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int target = question.trap(arr);
        System.out.println(target);
    }

    /**
     * 按列求，当前列的水深就是左边和右边的最小值 - 当前列的高度
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 0) return 0;
        int res = 0;
        int size = height.length;
        for (int i = 1; i < size; i++) {
            int leftMax = height[i], rightMax = height[i];
            // 寻找最左边的最大值
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < size; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

}
