package com.steve.algorithms.repeat.string;

import com.steve.algorithms.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class Question_3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() <= 0) return 0;
        int max = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Question_3 question = new Question_3();
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


        System.out.println(question.lengthOfLongestSubstring("pwwkew"));
    }

}
