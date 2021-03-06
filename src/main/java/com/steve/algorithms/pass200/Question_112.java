package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 简单：
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
public class Question_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        Question_112 question = new Question_112();
        TreeNode tmp = new TreeNode(5);
        TreeNode tmp2 = new TreeNode(4);
        TreeNode tmp22 = new TreeNode(8);
        TreeNode tmp3 = new TreeNode(11);
        TreeNode tmp33 = new TreeNode(13);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp44 = new TreeNode(7);
        TreeNode tmp5 = new TreeNode(2);
        TreeNode tmp6 = new TreeNode(1);
        tmp.left = tmp2;
        tmp.right = tmp22;
        tmp2.left = tmp3;
        tmp3.left = tmp44;
        tmp3.right = tmp5;

        tmp22.left = tmp33;
        tmp22.right = tmp4;
        tmp4.right= tmp6;
        System.out.println(question.hasPathSum(tmp, 23));
    }

}
