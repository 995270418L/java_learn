package com.steve.algorithms.recruit;

/**
 * 面试题13. 机器人的运动范围
 */
public class Question_11 {

    public static void main(String[] args) {
        Question_11 question = new Question_11();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int target = question.maxArea(arr);
        System.out.println(target);
    }

    public int maxArea(int[] height) {
        int n = height.length;
        if (n <= 1) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[j], height[i]) * (j - i);
                res = Math.max(res, area);
            }
        }
        return res;
    }

}
