package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

/**
 * 简单：
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 *
 */
public class Question_168 {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            n--;
            sb.append((char)(n % 26 + 'A'));
            n = n / 26;
        }
        sb.reverse();
        return sb.toString();
    }


    public static void main(String[] args) {
        Question_168 question = new Question_168();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(question.convertToTitle(52)); // 701 52
    }

}
