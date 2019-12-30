package com.steve.algorithms.pass300;

import com.steve.algorithms.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单：
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class Question_206 {

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)  return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        Question_206 question = new Question_206();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(question.reverseList2(l1));
    }

}
