package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;
import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class Question_144 {


    /**
     * curr -> left -> right
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() && root != null){
            while (root != null){
                root = root.left;
                stack.push(root);
            }
            TreeNode curr = stack.pop();
            res.add(curr.val);

        }
        return res;
    }

    public List<Integer> preorderTraversalRecv(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recv(root, res);
        return res;
    }

    private void recv(TreeNode root, List<Integer> res){
        if(root != null) {
            res.add(root.val);
            recv(root.left, res);
            recv(root.right, res);
        }
    }

    public static void main(String[] args) {
        Question_144 question = new Question_144();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(question.preorderTraversal(null));
    }

}
