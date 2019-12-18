package com.steve.algorithms.pass200;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 */
public class Question_139 {

    /**
     * dp 1
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                if(dp[i] && wordDict.contains(s.substring(i, j))){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if(s == null) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j< i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Question_139 question = new Question_139();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(question.wordBreak2("aaaaaaa", new LinkedList<String>(){{add("aaaa"); add("aaa");}}));
    }

}
