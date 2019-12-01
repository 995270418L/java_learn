package com.steve.algorithms.pass100;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class Question_9 {

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int xC = x;
        int res = 0, pop = 0;
        while(x != 0){
            pop = x % 10;
            if(res >= Integer.MAX_VALUE / 10)
                return false;
            res = res * 10 + pop;
            x = x / 10;
        }
        return res == xC;
    }

    public static void main(String[] args) {
        Question_9 q = new Question_9();
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(q.isPalindrome(121));
    }

}
