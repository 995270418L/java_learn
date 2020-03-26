package com.steve.algorithms.repeat.string;

import com.steve.algorithms.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 */
public class Question_76 {

    /**
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * 滑动窗口，怎么判断一个字符串属于另一个字符串呢？ 使用 HashMap
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0) return "";
        // 保存每个字符出现的频次 (条件是无序的)
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            int c = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), c+1);
        }
        int[] res = {-1, 0, 0};                              // 保留结果的， 0: 长度， 1: left index 2: right index
        Map<Character, Integer> findMap = new HashMap<>();  // l -> r 这个范围内的字符串是否有这个字符串
        int findCount = 0;                                  // 统计 l -> r 范围内找到的结果数
        int left = 0, right = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            int tmp = findMap.getOrDefault(c, 0);
            findMap.put(c, tmp + 1);
            if(tMap.containsKey(c) && tMap.get(c).intValue() == findMap.get(c).intValue()){
                findCount ++;
            }
            while (findCount == tMap.size() && left <= right){
                c = s.charAt(left);
                // 更新结果数组
                if(res[0] == -1 || right - left + 1 < res[0]){
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }
                findMap.put(c, findMap.get(c)- 1);
                if(tMap.containsKey(c) && findMap.get(c).intValue() < tMap.get(c).intValue()){
                    findCount -- ;
                }
                left ++;
            }
            right ++ ;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    public static void main(String[] args) {
        Question_76 question = new Question_76();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        System.out.println(question.minWindow("ABAACBAB","ABC"));
    }

}
