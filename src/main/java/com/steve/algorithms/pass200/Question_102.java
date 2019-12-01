package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Question_102 {

    /**
     * 递归的方式
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    public void helper(TreeNode node, int levels, List<List<Integer>> res){
        if(levels == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(levels).add(node.val);
        if(node.left != null){
            helper(node.left, levels + 1, res);
        }
        if(node.right != null){
            helper(node.right, levels + 1, res);
        }
    }

    /**
     * 非递归遍历方式
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            int count = queue.size();
            for(int i=0; i< count; i++){
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }


    public static void main(String[] args) {
        Question_102 question = new Question_102();
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

        System.out.println(question.levelOrder(tmp));
    }

}
