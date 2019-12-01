package com.steve.algorithms.pass100;

import com.steve.algorithms.base.TreeNode;

import java.util.Stack;

/**
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5, 但是其右子节点值为 4 .
 *
 */
public class Question_97 {

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer min = 0;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(min != 0 && root.val <= min) return false;
            min = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 递归法
     * @param root
     * @param lower
     * @param higher
     * @return
     */
    public boolean helper(TreeNode root, Integer lower, Integer higher){
        if(root == null) return true;
        int val = root.val;
        if(lower != null && lower >= val) return false;
        if(higher != null && higher <= val) return false;
        // 比较左右子树
        if(!helper(root.right, val, higher)) return false;
        if(!helper(root.left, lower, val)) return false;
        return true;
    }


    public static void main(String[] args) {
        Question_97 question = new Question_97();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        tmp5.left = tmp;
        tmp5.right = tmp4;
        tmp4.left = tmp3;
        tmp4.right = tmp6;
        System.out.println(question.isValidBST(tmp5));
    }

}
