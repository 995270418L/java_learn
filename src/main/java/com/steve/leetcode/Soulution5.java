package com.steve.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Soulution5 {

    public static void main(String[] args) {
        System.out.println(test2(8));
//        System.out.println(solve("abcba"));
    }

    /**
     * 暴力枚举法
     * @param s
     * @return
     */
    public static String solve(String s){
        String result = "";
        for(int i=0; i< s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String str = s.substring(i,j);
                String strReverse = reverse(str);
                if(strReverse.equals(str)){
                    result = result.length() > str.length() ? result : str;
                }
            }
        }
        return result;
    }

    private static String reverse(String str) {
        String res = "";
        for(int i=str.length() - 1; i >= 0; i--){
            res += str.charAt(i);
        }
        return res;
    }


    /**
     * fibonacci dynamic plan solve test
     * @param n
     * @return
     */
    public static int test(int n){
        if(n <=0 ) return 0;
        int[] memo = new int[n+1];
        // 填充数组
        for(int i=0; i<=n ;i ++){
            memo[i] = -1;
        }
        return recursive(n, memo);
    }

    /**
     * 自顶向下备忘录法 处理动态规划问题
     * @param n
     * @param memo
     * @return
     */
    private static int recursive(int n, int[] memo) {
        if(memo[n] != -1) return memo[n];
        if(n <= 2 ){
            memo[n] = 1;
        }else {
            memo[n] = recursive(n - 1, memo) + recursive(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 自底向上的动态规划方法处理 finonacci
     * @param n
     * @return
     */
    public static int test2(int n){
        if(n <= 1) return 1;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<=n; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

}
