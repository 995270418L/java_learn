package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;
import com.steve.leetcode.ListNode;

/**
 *
 * 简单：
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false
 *
 *
 */
public class Question_110 {

    public boolean isBalanced(TreeNode root) {
        return recursive(root) != -1;
    }

    public int recursive(TreeNode curr){
        if(curr == null) return 0;
        int left = recursive(curr.left);
        if(left == -1) return -1;
        int right = recursive(curr.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        Question_110 question = new Question_110();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp22 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp33 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp44 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        tmp.left = tmp2;
        tmp.right = tmp22;
        tmp2.left = tmp3;
        tmp2.right = tmp33;
        tmp3.left = tmp4;
        tmp3.right = tmp44;
        System.out.println(question.isBalanced(tmp));
    }

}
