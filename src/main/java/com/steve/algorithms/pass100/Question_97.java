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
     * 这是一种错误的贪心过程，这里的判断条件是当每颗子树都是一颗二叉搜索数，整棵树就都是二叉搜索树了。错误点在于整体上并不是这么做的。
     * @param root
     * @return
     */
    @Deprecated
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        boolean res = true;
        if(root.left != null) res = root.left.val < root.val;
        if(root.right != null) res = root.right.val > root.val;
        return res && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root, Integer lower, Integer higher) {
        if(root == null) return true;
        boolean res = true;
        if(root.left != null) res = root.left.val < root.val;
        if(root.right != null) res = root.right.val > root.val;
        return res && isValidBST(root.left) && isValidBST(root.right);
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
        TreeNode tmp = new TreeNode(10);
        TreeNode tmp2 = new TreeNode(5);
        TreeNode tmp3 = new TreeNode(15);
        TreeNode tmp4 = new TreeNode(6);
        TreeNode tmp5 = new TreeNode(20);
        tmp.left = tmp2;
        tmp2.right = tmp3;
        tmp.right = tmp4;
        tmp4.right = tmp5;
        System.out.println(question.isValidBST2(tmp));
    }

}
