package com.steve.algorithms.pass300;

import com.steve.algorithms.base.TreeNode;

/**
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 */
public class Question_201 {

    /**
     * 看0的个数就知道了
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int zeroNum = 0;
        while (n > m){
            zeroNum ++;
            m = m >> 1;
            n = n >> 1;
        }
        return n << zeroNum;
    }


    public static void main(String[] args) {
        Question_201 question = new Question_201();
        TreeNode root = new TreeNode(1);
        System.out.println(question.rangeBitwiseAnd(5,7));
    }

}
