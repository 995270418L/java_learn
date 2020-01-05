package com.steve.algorithms.pass300;

/**
 * 简单:
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 */
public class Question_217 {

    /**
     * hash suanfa
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        return false;
    }

    public static void main(String[] args) {
        Question_217 question = new Question_217();
        System.out.println(question.containsDuplicate(new int[]{1,3,5,7,9}));
    }

}
