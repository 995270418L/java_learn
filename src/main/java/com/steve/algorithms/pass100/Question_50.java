package com.steve.algorithms.pass100;


/**
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 *
 */
public class Question_50 {

    /**
     * 暴力乘法, 超出时间限制
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double start = n > 0 ? x : 1/x ;
        n = n > 0 ? n : -n;
        double res = start;
        for(;n > 1; n--){
//            if(res >= Integer.MAX_VALUE / start) return 0; // 发生溢出
            res = res * start;
        }
        return res;
    }

    public double myPow2(double x, int n){
        if(n == 0) return 1;
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        return pow(x, n);
    }

    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        double half = pow(x, n / 2 );
        if(n % 2 == 0){
            return half * half;
        }else{
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        Question_50 question = new Question_50();
        System.out.println(question.myPow2(2, 10));
    }

}
