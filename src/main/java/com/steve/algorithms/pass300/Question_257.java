package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单：
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */
public class Question_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrace(root, res, "");
        return res;
    }

    public void backtrace(TreeNode root, List<String> path, String str){
        if(root != null){
            str += String.valueOf(root.val);
            if(root.left == null && root.right == null){
                path.add(str);
            }else{
                str += "->";
                backtrace(root.left, path, str);
                backtrace(root.right, path, str);
            }
        }
    }

    public static void main(String[] args) {
        Question_257 question = new Question_257();
        int[][] src = new int[1][1];
        src[0][0] = 1;
        System.out.println(question.binaryTreePaths(null));
    }

}
