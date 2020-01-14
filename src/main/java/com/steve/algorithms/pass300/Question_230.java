package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */
public class Question_230 {

    /**
     * 二叉搜索树中序遍历为升序数组
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res.get(k - 1);
    }

    public void recursive(TreeNode root, List<Integer> res){
        if(root != null){
            recursive(root.left, res);
            res.add(root.val);
            recursive(root.right, res);
        }
    }


    public static void main(String[] args) {
        Question_230 question = new Question_230();
        TreeNode root = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        Boolean a = new Boolean(false);
        System.out.println(a);
    }

}
