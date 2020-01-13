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

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i,j =0; j <nums.length; j++){
            i = j;
            while ((j + 1) < nums.length && nums[j+1] == nums[j] + 1) j ++;
            if(i == j)
                res.add(nums[i] + "");
            else
                res.add(nums[i] + "->" + nums[j]);
        }
        return res;
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

        System.out.println(question.summaryRanges(new int[]{1,2,3,5,6}));
    }

}
