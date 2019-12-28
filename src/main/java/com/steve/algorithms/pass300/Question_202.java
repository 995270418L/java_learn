package com.steve.algorithms.pass300;

import com.steve.algorithms.base.TreeNode;

/**
 * 简单：
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class Question_202 {

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
        Question_202 question = new Question_202();
        TreeNode root = new TreeNode(1);
        System.out.println(question.rangeBitwiseAnd(5,7));
    }

}
