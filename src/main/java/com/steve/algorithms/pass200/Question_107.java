package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.*;

/**
 * 简单：
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */
public class Question_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            int count = queue.size();
            for(int i=0; i< count; i++){
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Question_107 question = new Question_107();
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
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(question.levelOrderBottom(tmp));
    }

}
