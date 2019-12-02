package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 简单：
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 *
 */
public class Question_111 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i=0; i< count; i++){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right == null){
                    queue.clear();
                    return level;
                }
                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
            level ++;
        }
        return level;
    }


    public static void main(String[] args) {
        Question_111 question = new Question_111();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp22 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp33 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp44 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        tmp.left = tmp2;
        tmp.right = tmp22;
        tmp2.left = tmp3;
        tmp2.right = tmp33;
        tmp3.left = tmp4;
        tmp3.right = tmp44;
        System.out.println(question.minDepth(tmp));
    }

}
