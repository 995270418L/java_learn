package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

import java.util.Stack;

/**
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 *
 */
public class Question_151 {


    public String reverseWords(String s) {
        String[] strSplit = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strSplit.length-1; i> 0; i--){
            String newStr = strSplit[i];
            if(newStr.equals("")) continue;
            sb.append(strSplit[i]);
            sb.append(" ");
        }
        sb.append(strSplit[0]);
        return sb.toString();
    }
    

    public static void main(String[] args) {
        Question_151 question = new Question_151();
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(question.reverseWords("  hello    world  "));
    }

}
