package com.steve.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 简单:
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "heoll", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 *
 */
public class Question_28 {

    public static void main(String[] args) {
        Question_28 question = new Question_28();
//        "mississippi"
//        "sippj"
        System.out.println(question.strStr("mississippi", "sippj"));
    }
    /**
     * sunday 算法 (KMP 算法的变种)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return -1;
        if(needle == "")
            return 0;
        // 获取偏移表
        Map<Character, Integer> offsetTable = offsetTable(needle);
        int idx = 0;
        while(idx + needle.length() <= haystack.length()){
            String temp = haystack.substring(idx, idx+needle.length());
            if(temp.equals(needle)){
                return idx;
            }else {
                if(idx + needle.length() < haystack.length()){ // 这里用 “=” 号会出现越界的情况
                    char i = haystack.charAt(idx+needle.length());
                    if(offsetTable.get(i) == null){
                        idx = idx +  needle.length() + 1;
                    }else{
                        idx = idx + offsetTable.get(i);
                    }
                }else{
                    return -1;
                }
            }
        }
        return idx + needle.length() >= haystack.length() ? -1 : idx;
    }

    /**
     * 辅助表， sheet[w] = len(str) - rightIndexOf[w] if w in str else sheet[w] = len(str) + 1
     * @param str
     * @return
     */
    public Map<Character, Integer> offsetTable(String str){
        Map<Character, Integer> map = new HashMap();
        for(int j=str.length() -1; j>=0 ;j--){
            if(map.get(str.charAt(j)) == null)
                map.put(str.charAt(j), str.length() - j);
        }
        return map;
    }

}
