package com.steve.algorithms.recruit;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * <p>
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class Question_63 {

    public static void main(String[] args) {
        Question_63 question = new Question_63();
        String[] strs = {"flight", "flow", "flower"};
        System.out.println(question.lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }

}
