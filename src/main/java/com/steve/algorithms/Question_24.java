package com.steve.algorithms;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class Question_24 {

    public ListNode swapPairsRecursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsRecursive(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;   // 交换两个节点
            end.next = start;        // 交换两个节点
            temp = start;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Question_24 question = new Question_24();
        System.out.println(question.swapPairs(null));
    }

}
