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

    public String minWindow(String s, String t) {
        return null;
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


        System.out.println(question.minWindow("pwwkew", "test"));
    }

}
