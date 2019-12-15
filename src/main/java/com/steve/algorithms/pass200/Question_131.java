package com.steve.algorithms.pass200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 *
 */
public class Question_131 {

    int len;
    List<List<String>> res = new ArrayList<>();

    /**
     * 回溯 + 剪枝
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if(s == null || s.length() <=0 ) return new ArrayList<>();
        len = s.length();
        backtrace(s, 0, new Stack<String>());
        return res;
    }

    public void backtrace(String s, int start, Stack<String> temp){
        if(start == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<len; i++){
            if(!checkPalindrome(s, start, i)) continue;
            temp.add(s.substring(start, i+1));
            backtrace(s, i+1, temp);
            temp.pop();
        }
    }


    public boolean checkPalindrome(String s, int start, int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start ++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        Question_131 question = new Question_131();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        System.out.println(question.partition("aab"));
    }

}
