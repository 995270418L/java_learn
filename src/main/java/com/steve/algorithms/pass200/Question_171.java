package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

/**
 * 简单：
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 */
public class Question_171 {

    public int titleToNumber(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int num = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + num;
        }
        return sum;
    }


    public static void main(String[] args) {
        Question_171 question = new Question_171();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(question.titleToNumber("AZ")); // 701 52
    }

}
