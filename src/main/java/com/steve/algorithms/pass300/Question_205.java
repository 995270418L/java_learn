package com.steve.algorithms.pass300;

/**
 * 简单：
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 */
public class Question_205 {

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
        Question_205 question = new Question_205();
        System.out.println(question.countPrimes2(10));
    }

}
