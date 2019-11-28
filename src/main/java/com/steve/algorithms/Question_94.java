package com.steve.algorithms;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 递归解法
     * @param root
     * @param res
     */
    public void helper(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null){
                helper(root, res);
            }
            res.add(root.val);
            if(root.right != null){
                helper(root, res);
            }
        }
    }

    /**
     * 基于栈的遍历 (中序遍历)
     */
    public List<Integer> stackRes(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 基于栈的遍历 (前序遍历)
     */
    public List<Integer> stackRes2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    /**
     * 基于栈的遍历 (后序遍历)
     */
    public List<Integer> stackRes3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

        }
        return res;
    }


    public static void main(String[] args) {
        Question_94 question = new Question_94();
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
        System.out.println(question.stackRes2(tmp));
    }

}
