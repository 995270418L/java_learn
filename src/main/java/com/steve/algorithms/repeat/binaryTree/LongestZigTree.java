package com.steve.algorithms.repeat.binaryTree;

import com.steve.algorithms.base.TreeNode;

/**
 * 二叉树中最长的 Z 字形子树  1372. 二叉树中的最长交错路径
 */
public class LongestZigTree {

    private int res;

    /**
     * 参考解答: https://mp.weixin.qq.com/s/mh9dn5HXN6y5EN3T9zSbeg
     * 1: 拆解成子问题，有多少个子问题就有多少个返回值
     * 2: 提取全局变量
     * 3: 编写递归函数。
     * <p>
     * <p>
     * 这个问题的子问题：
     * 1. 左子树的最长 Z 字形路径
     * 2. 右子树的最长 Z 字形路径
     * 3. 1 + Math.max(左子树的最长右之Z字形路径， 右子树的最长左之Z字形路径)
     *
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        helper(root);
        return res - 1; // 特殊情况，当左子树为 0 的时候，我们也给它加了1.所以需要减一
    }

    /**
     * @param root
     * @return index 0: 左子树的最长 Z 字形路径 1：右子树的最长 Z 字形路径
     */
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftzz = helper(root.left);
        int[] rightzz = helper(root.right);
        int t = 1 + Math.max(leftzz[1], rightzz[0]);
        res = Math.max(res, t);
        return new int[]{1 + leftzz[1], 1 + rightzz[0]};
    }

}
