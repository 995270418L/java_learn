package com.steve.algorithms.pass300;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单：
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 */
public class Question_205 {

    /**
     * 双向映射
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(map.containsKey(tempS)){
                if (map.get(tempS) != tempT) return false;
            }else{
                map.put(tempS, tempT);
            }
        }
        map = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(map.containsKey(tempT)){
                if (map.get(tempT) != tempS) return false;
            }else{
                map.put(tempT, tempS);
            }
        }
        return true;
    }

    /**
     * 翻译，将两个字符串转换为第三个中间的语言，比较是否相等. 超出时间限制
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        return translate(s).equals(translate(t));
    }

    public String translate(String s){
        int[] map = new int[128]; // char 范围
        int count = 1;
        String res = "";
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(map[temp] == 0){
                map[temp] = count;
                count ++;
            }
            res += map[temp];
        }
        return res;
    }

    public boolean isIsomorphic3(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(map.containsKey(tempS)){
                if (map.get(tempS) != tempT) return false;
            }else{
                if(map.containsValue(tempT)) return false; // 解决 ao, oo 的映射问题  ab, ba, contain value实现太糟糕了
                map.put(tempS, tempT);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question_205 question = new Question_205();
        System.out.println(question.isIsomorphic2("egg","add"));
    }

}
