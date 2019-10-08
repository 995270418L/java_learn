package com.steve.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 */
public class Question_3 {

    public static void main(String[] args) {

        Question_3 q = new Question_3();
        System.out.println(q.lengthOfLongestSubstring3("pwwkew"));

    }

    /**
     * 双重遍历的写法，比较笨，时间复杂度 O(n^2)， 空间复杂度位0（n）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        List<Character> list = new ArrayList<>();
        int maxLen = 0;
        for(int i=0; i < len; i ++){
            list.add(s.charAt(i));
            for(int j=i+1; j < len; j++){
                Character t = s.charAt(j);
                if(!list.contains(t)){
                    list.add(t);
                }else{
                    break;
                }
            }
            if(list.size() > maxLen){
                maxLen = list.size();
            }
            list.clear();
        }
        return maxLen;
    }

    /**
     * 滑动窗口解法, 就是当发现重复字符时，需要滑动这个窗口，所以需要记录窗口的left index 和最右边的 right index， 最大长度就是 right index - left index + 1
     * 时间复杂度 O（n）, 空间复杂度 O（1）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int leftIndex = 0;
        for(int i=0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                leftIndex = Math.max(leftIndex, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - leftIndex + 1);
        }
        return max;
    }

    /**
     * 滑动窗口精简版本
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int flag = 0;
        s.indexOf(s.charAt(1), flag);
        return 0;
    }

    /**
     * 变体，求最长子序列
     * @param s
     * @return
     */
    public String lengthOfLongestSubstring4(String s) {
        if(s.length() <= 0){
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int leftIndex = 0;
        String str = null;
        for(int i=0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                leftIndex = Math.max(leftIndex, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            if((i - leftIndex + 1) > max){
                str = s.substring(leftIndex, i + 1);
                max = i - leftIndex + 1;
            }
        }
        return str;
    }



}
