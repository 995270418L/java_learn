package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push(String.valueOf(root.val));
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            if(node.left == null && node.right == null) res.add(path);
            if(node.left != null){
                nodeStack.push(node.left);
                pathStack.add(path + "->" + node.left.val);
            }
            if(node.right != null){
                nodeStack.push(node.right);
                pathStack.add(path + "->" + node.right.val);
            }
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @param path
     * @param str
     */
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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        System.out.println(question.binaryTreePaths2(t1));
    }

}
