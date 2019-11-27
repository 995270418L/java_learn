package com.steve.algorithms;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class Question_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }


    public static void main(String[] args) {
        Question_94 question = new Question_94();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        tmp.right = tmp2;
        TreeNode tmp3 = new TreeNode(3);
        tmp2.left = tmp3;
        System.out.println(question.inorderTraversal(tmp));
    }

}
