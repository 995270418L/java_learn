package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 */
public class Question_199 {

    /**
     * 层次遍历，最右边的保存下来
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(i == size - 1) res.add(node.val);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Question_199 question = new Question_199();
        TreeNode root = new TreeNode(1);
        System.out.println(question.rightSideView(root));
    }

}
