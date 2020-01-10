package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.*;

/**
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 */
public class Question_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length < 1) return res;
        int start = nums[0];
        for(int i=1; i<nums.length; i++){
            if (nums[i] - nums[i-1] <= 1) {
                continue;
            }
            int end = nums[i-1];
            res.add(end == start ? "" +start : "" + start + "->" +end);
            start = end;
        }
        return res;
//        res.add();
    }

    public static void main(String[] args) {
        Question_228 question = new Question_228();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
//        t3.right = t7;

        System.out.println(question.summaryRanges(new int[]{1,2,3,4,5}));
    }

}
