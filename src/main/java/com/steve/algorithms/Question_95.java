package com.steve.algorithms;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Question_95 {

    public List<TreeNode> generateTrees(int n) {
        return null;
    }


    public static void main(String[] args) {
        Question_95 question = new Question_95();
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
        System.out.println(question.generateTrees(5));
    }

}
