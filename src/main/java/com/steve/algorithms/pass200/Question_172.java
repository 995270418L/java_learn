package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

/**
 * 简单：
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n)。
 *
 */
public class Question_172 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0){
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    public static void main(String[] args) {
        Question_172 question = new Question_172();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(question.trailingZeroes(100000)); // 701 52
    }

}
