package com.steve.algorithms.pass300;

/**
 * 简单：
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 */
public class Question_204 {

    /**
     * 暴力法, 效率过低
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 1;
        for(int i=3; i<n; i++){
            boolean primes = false;
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    primes = true;
                    break;
                }
            }
            if(!primes) count ++;
        }
        return count;
    }

    /**
     * 排除法
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2; i * i < n; i++){
            if(!isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(!isPrime[i]) count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Question_204 question = new Question_204();
        System.out.println(question.countPrimes2(10));
    }

}
