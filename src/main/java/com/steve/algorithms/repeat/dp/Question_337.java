package com.steve.algorithms.repeat.dp;


import com.steve.algorithms.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Question_337 {

    /**
     * 子问题就是，爷爷节点和所有的孙子节点的和和儿子节点的和相比较，看谁的更大。 递归，也可以用自顶向下的动态规划来提升速度
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int money = root.val;
        if(root.left != null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            money += rob(root.right.right) + rob(root.right.left);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    Map<TreeNode, Integer> memo = new HashMap<>();
    /**
     * 有记忆性的递归，自顶而下的递归
     * @param root
     * @return
     */
    public int robR(TreeNode root) {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if(root.left != null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            money += rob(root.right.right) + rob(root.right.left);
        }
        int val = Math.max(money, rob(root.left) + rob(root.right));
        memo.put(root, val);
        return memo.get(root);
    }

    /**
     * 自底向上的动态规划，
     * 状态定义：
     *  dp[i][j] 表示第 i 个节点在第 j 种状态下的最大收益
     * 每个节点可以选择偷或者不偷两种状态(0 和 1)
     *  1：当前节点偷，最大值 dp[i][1] = dp[i-1][0] + dp[i-1][0] + nums[i];
     *  2：当前节点不偷，最大值 dp[i][0] = dp[i-1][1] + dp[i-1][1];
     *
     * 写不出来，MD
     *
     * 下面的代码是强行理解的
     * @param root
     * @return
     */
    public int robM(TreeNode root) {
        if(root == null) return 0;
        int[] res = robInternal(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robInternal(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        // 当前节点不偷, 等于两子节点能偷到的最大的钱的数目
        res[0] = Math.max(left[1],left[0]) + Math.max(right[1], right[0]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

    public static void main(String[] args) {
        Question_337 question = new Question_337();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        left1.right = left2;
        right1.right = right2;

        int res = question.robM(root);
        System.out.println(res);
    }

}
