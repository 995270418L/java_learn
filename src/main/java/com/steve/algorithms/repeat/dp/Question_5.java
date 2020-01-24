package com.steve.algorithms.repeat.dp;

public class Question_5 {

    /**
     * 动态规划:
     * 1. 定义状态:
     *      dp[i][j] 为 s[i] -> s[j] 之间的字符是否是回文串
     * 2. 状态转移：
     *      dp[i][j] = s[i] == s[j] and dp[i+1][j-1] = true
     * 3. 状态初始化，看 i + 1 和 j - 1 的下标是否越界
     * 4. 考虑输出， 每次为 true 记录一下字符串的长度
     * 5. 考虑状态是否可以压缩。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;
        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for(int j = 1; j< n; j++){
            for(int i=0; i< j; i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 3){ // 这也算是在完成初始化的过程
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]){
                    int newLen = j - i + 1;
                    if(newLen > maxLen){
                        start = i;
                        maxLen = newLen;
                    }
                }
            }
        }
        return s.substring(start, maxLen + start);
    }

    public static void main(String[] args) {
        Question_5 question = new Question_5();
        System.out.println(question.longestPalindrome("ac"));
    }

}
