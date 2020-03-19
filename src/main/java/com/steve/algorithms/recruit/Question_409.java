package com.steve.algorithms.recruit;

/**
 * 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 */
public class Question_409 {

    public int longestPalindrome(String s) {
        int[] dic = new int[128];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            dic[c] += 1;
        }
        int res = 0;
        for(int i : dic){
            res += i / 2 * 2;
            if(res % 2 == 0 && i % 2 == 1){
                res ++;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        Question_409 question = new Question_409();
        int[][] src = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        System.out.println(question.longestPalindrome("AAAAA"));
    }

}
