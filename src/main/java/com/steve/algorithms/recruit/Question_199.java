package com.steve.algorithms.recruit;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 */
public class Question_199 {

    public static void main(String[] args) {
        Question_199 question = new Question_199();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(question.rightSideView(null));
    }

    /**
     * 不多BB, 层次遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }

}
