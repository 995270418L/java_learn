package com.steve.algorithms.pass300;


import com.steve.algorithms.base.ListNode;
import com.steve.algorithms.base.TreeNode;

/**
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class Question_234 {

    public boolean isPalindrome(ListNode head) {
        return false;
    }


    public static void main(String[] args) {
        Question_234 question = new Question_234();
        TreeNode root = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        Boolean a = new Boolean(false);
        System.out.println(question.isPalindrome(null));
    }

}
