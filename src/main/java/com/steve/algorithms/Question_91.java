package com.steve.algorithms;

/**
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 *
 */
public class Question_91 {

    /**
     * 条件过滤 两个变量使用
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.charAt(0) == '0') return 0;
        int curr = 1, pre = 1;
        for(int i=1; i< s.length(); i++){
            int tmp = curr; // dp[i-1]
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') curr = pre;
                else return 0;
            }else if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')){
                curr += pre;
            }
            // 更新值
            pre = tmp; // pre = dp[i-1]
        }
        return curr;
    }

    public static void main(String[] args) {
        Question_91 question = new Question_91();
        int[] nums1 = {1,2,2};
        String s = "226";
        System.out.println(question.numDecodings(s));
    }

}
