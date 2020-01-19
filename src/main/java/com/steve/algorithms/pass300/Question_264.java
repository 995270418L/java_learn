package com.steve.algorithms.pass300;


/**
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Question_264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for(int i=1; i<n; i++){
            dp[i] = Math.min(Math.min(dp[index2] * 2, dp[index3] * 3), dp[index5] * 5);
            while (dp[index2] * 2 <= dp[i]) ++ index2;
            while (dp[index3] * 3 <= dp[i]) ++ index3;
            while (dp[index5] * 5 <= dp[i]) ++ index5;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Question_264 question = new Question_264();
        System.out.println(question.nthUglyNumber(10));
    }

}
