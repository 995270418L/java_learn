package com.steve.algorithms.pass300;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
public class Question_242 {

    /**
     * 如果是 unicode 字符，就使用 hash 表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] counter = new int[26]; // 26 个字母
        for (int i = 0; i< s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']-- ;
        }
        for(int coun : counter){
            if(coun != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question_242 question = new Question_242();
        int[][] src = new int[1][1];
        src[0][0] = 1;
        System.out.println(question.isAnagram("2-1-1", "ssfsa"));
    }

}
