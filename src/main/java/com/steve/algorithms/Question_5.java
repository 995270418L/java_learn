package com.steve.algorithms;

/**
 * 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 */
public class Question_5 {

    public static void main(String[] args) {
        Question_5 question = new Question_5();
//        System.out.println(question.longestPalindrome("babad"));

//        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
        String p = "cbbd";
        System.out.println(question.longestPalindrome2(p));
    }

    /**
     * 暴力破解, 枚举所有子串，对每个子串进行判断，判断是否为回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String result = "";
        for(int i=0; i< s.length(); i++){
            for(int j=i+1; j< s.length(); j++){
                String tmp = s.substring(i, j+1);
                if(checkIsBack(tmp)){
                    if(tmp.length() > result.length()){
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    public boolean checkIsBack(String s){
        int i=0, j = s.length() - 1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }


    /**
     * 最长回文子串, 最长公共子串递推式： d[i][j] = d[i-1][j-1] + 1 ; 当且仅当 d[i] == d[j] 的时候 else d[i][j] = 0
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if(s.equals("")){
            return "";
        }
        String sR = new StringBuffer(s).reverse().toString();
        int len = s.length();
        int[][] d = new int[len][len];  // 保留的最长子串的长度
        int maxLen = -1;
        int maxEnd = -1;
        for(int i=0; i< len; i++){
            for(int j=0; j<len; j++){
                if(s.charAt(i) == sR.charAt(j)){
                    if(i == 0 || j == 0){
                        d[i][j] = 1;
                    }else{
                        d[i][j] = d[i-1][j-1] + 1;
                    }

                    if( d[i][j] > maxLen ) {
                        // 得到最长公共子串，再判断它是不是回文串
                        int beforeR = len - j - 1;  // 得到最后一个字符的反转前的下坐标
                        int rC = beforeR + d[i][j] -1; // 判断是否是回文，回文的话，加上长度应该是相等的。 下标的话再 -1
                        if(rC == i) {
                            maxLen = d[i][j];
                            maxEnd = i;
                        }
                    }
                }
            }
        }
        if(maxEnd > -1){
            return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
        }else{
            return "";
        }
    }

    /**
     * 自顶向下的备忘录式动态规划
     *
     * @param p
     * @param n
     * @return
     */
    public int dpDemo(int[] p, int n){
        int[] v = new int[n];
        for(int i=0; i<n; i++){
            v[i] = -1;
        }
        return memoDpDemo(p, n, v);
    }

    public int memoDpDemo(int[] p, int n, int[] v) {
        if (v[n] != -1)
            return v[n];
        int max = 0;
        if (n == 0)
            return 0;
        else{
            for(int i=1; i<n; i++){
                max = Math.max(max, p[i] + memoDpDemo(p, n-i, v));
            }
        }
        v[n] = max;
        return max;
    }

    /**
     * 自底向上的递归求解方式
     * @param p
     * @param n
     * @return
     */
    public int dpDemo2(int[] p, int n){
        int[] v = new int[n+1];
        for(int j=1; j<=n; j++){
            int q = 0 ;
            for(int i=1; i<= j; i++){
                q = Math.max(q, p[i-1] + v[j - i]);
            }
            v[j] = q;
        }
        return v[n];
    }
}
