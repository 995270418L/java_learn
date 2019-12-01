package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.*;

/**
 * 简单：
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class Question_108 {

    /**
     * 数组还原树，都是找到根节点，然后递归生成左子树和右子树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(nums, 0, nums.length);
    }

    public TreeNode recursive(int[] nums, int start, int end){
        if(start == end) return null;
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursive(nums, start, mid);
        root.right = recursive(nums, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        Question_108 question = new Question_108();
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
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {-10,-3,0,5,9};
        System.out.println(question.sortedArrayToBST(inorder));
    }

}
