package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

/**
 * 简单
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 *
 */
public class Question_101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return recursive(root.left, root.right);
    }

    public boolean recursive(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }


    public static void main(String[] args) {
        Question_101 question = new Question_101();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        System.out.println(question.isSymmetric(tmp5));
    }

}
