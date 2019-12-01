package com.steve.algorithms.pass100;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 *
 */
public class Question_29 {

    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);          // 相同则为0，不同则为1
        int result = 0;
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        while(dividend <= divisor){
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)){
                if(temp_divisor < (Integer.MIN_VALUE >> 1)) break;
                temp_divisor = temp_divisor << 1;
                temp_result = temp_result << 1;
            }
            result += temp_result;
            dividend = dividend - temp_divisor;
        }
        if(!sign){
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE; // 如果result等于最小的32为整形，则转成正数会出现溢出。所以得判断这种情况
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
//        int x = Integer.MIN_VALUE;
//        System.out.println(x);
//        int y = x -1;
//        System.out.println(y);
        Question_29 question = new Question_29();
        System.out.println(question.divide(-2147483648, -1));
    }

}
