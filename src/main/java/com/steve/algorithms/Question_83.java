package com.steve.algorithms;

import com.steve.algorithms.base.ListNode;

/**
 * 简单:
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class Question_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null){
            if((fast.next != null && fast.next.val != fast.val) || fast.next == null){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Question_83 question = new Question_83();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        System.out.println(question.deleteDuplicates(node1));
    }

}
