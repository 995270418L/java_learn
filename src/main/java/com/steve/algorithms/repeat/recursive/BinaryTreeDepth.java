package com.steve.algorithms.repeat.recursive;

import com.steve.algorithms.base.TreeNode;

/**
 * 二叉树的最大深度
 */
public class BinaryTreeDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode h1 = new TreeNode(9);
        TreeNode h2 = new TreeNode(20);
        TreeNode h3 = new TreeNode(15);
        TreeNode h4 = new TreeNode(7);
        head.left = h1;
        head.right = h2;
        h2.left = h3;
        h2.right = h4;
        BinaryTreeDepth binaryTreeDepth =new BinaryTreeDepth();
        System.out.println(binaryTreeDepth.maxDepth(head));
    }

}
