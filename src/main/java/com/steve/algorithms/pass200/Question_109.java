package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;
import com.steve.leetcode.ListNode;

/**
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class Question_109 {

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        Question_109 question = new Question_109();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        tmp.left = tmp2;
        tmp.right = tmp3;
        tmp2.left = tmp4;
        tmp2.right = tmp5;
        tmp3.left = tmp6;

        ListNode node = new ListNode(0);
        System.out.println(question.sortedListToBST(node));
    }

}
