package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树，原地将它展开为链表。(前序遍历)
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *
 */
public class Question_114 {

    /**
     * 迭代 和 递归两种解法
     * @param root
     */
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode more_right = root.left;
                while (more_right.right != null) more_right = more_right.right;
                more_right.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flattenRecv(TreeNode root) {
        if(root == null) return;
        flattenRecv(root.left);
        flattenRecv(root.right);
        if(root.left != null){
            TreeNode more_right = root.left;
            while (more_right.right != null) more_right = more_right.right;
            more_right.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        root = root.right;
    }

    private void helper(TreeNode root){

    }

    public static void main(String[] args) {
        Question_114 question = new Question_114();
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
        question.flatten(tmp);
    }

}
