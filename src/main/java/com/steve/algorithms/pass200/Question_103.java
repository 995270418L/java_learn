package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.awt.geom.Line2D;
import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 */
public class Question_103 {

    /**
     * 1. 首先尝试递归，发现递归实现不了旋转功能。所以只能用迭代了（两个栈 + BFS）
     *
     * 2. 借助两个栈来实现，奇数层使用奇数栈，偶数层使用偶数栈
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> stack_even = new Stack<>();
        Stack<TreeNode> stack_odd = new Stack<>();
        stack_even.push(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;                       // flag 表示下一层是奇数层还是偶数层, false 表示下一层是偶数层
        while (!stack_even.isEmpty() || !stack_odd.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            if(flag){
                int count = stack_odd.size();
                for(int i=0; i < count; i++){
                    TreeNode treeNode = stack_odd.pop();
                    temp.add(treeNode.val);
                    if(treeNode.right != null){
                        stack_even.push(treeNode.right);
                    }
                    if(treeNode.left != null){
                        stack_even.push(treeNode.left);
                    }
                }
            }else{
                int count = stack_even.size();
                for(int i=0; i < count; i++){
                    TreeNode treeNode = stack_even.pop();
                    temp.add(treeNode.val);
                    if(treeNode.left != null){
                        stack_odd.push(treeNode.left);
                    }
                    if(treeNode.right != null){
                        stack_odd.push(treeNode.right);
                    }
                }
            }
            res.add(temp);
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        Question_103 question = new Question_103();
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

        System.out.println(question.zigzagLevelOrder(tmp));
    }

}
