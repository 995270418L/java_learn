package com.steve.algorithms.repeat.recursive;

import com.steve.algorithms.base.TreeNode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowN {

    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            N = -N;
            x = 1 / x;
        }
        if(N == 1 ) return x;
        if(N == 0) return 1;
        double half = myPow(x, (int)(N / 2));
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode h1 = new TreeNode(9);
        TreeNode h2 = new TreeNode(20);
        TreeNode h3 = new TreeNode(15);
        TreeNode h4 = new TreeNode(7);
        head.left = h1;
        head.right = h2;
        h2.left = h3;
        h2.right = h4;
        PowN binaryTreeDepth =new PowN();
        System.out.println(binaryTreeDepth.myPow(2,-2147483648));
    }

}
