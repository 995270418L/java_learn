package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 */
public class Question_113 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> inner = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        sum -= root.val;
        inner.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == 0){
                res.add(new ArrayList<>(inner)); // 得拷贝，不然会 remove 所有节点信息
            }
        }
        if(root.left != null) pathSum(root.left, sum);
        if(root.right != null) pathSum(root.right, sum);
        inner.remove(inner.size() - 1);
        return res;
    }

    public static void main(String[] args) {
        Question_113 question = new Question_113();
        TreeNode tmp = new TreeNode(5);
        TreeNode tmp2 = new TreeNode(4);
        TreeNode tmp22 = new TreeNode(8);
        TreeNode tmp3 = new TreeNode(11);
        TreeNode tmp33 = new TreeNode(13);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp44 = new TreeNode(7);
        TreeNode tmp5 = new TreeNode(2);
        TreeNode tmp6 = new TreeNode(1);
        tmp.left = tmp2;
        tmp.right = tmp22;
        tmp2.left = tmp3;
        tmp3.left = tmp44;
        tmp3.right = tmp5;

        tmp22.left = tmp33;
        tmp22.right = tmp4;
        tmp4.right= tmp6;
        System.out.println(question.pathSum(tmp, 23));
    }

}
