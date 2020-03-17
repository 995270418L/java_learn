package com.steve.algorithms.repeat.recursive;

import com.steve.algorithms.base.ListNode;

/**
 * 反转链表
 */
public class ReverseLinkedNode {

    /**
     *  1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *  result:
     *  5 -> 4 -> 3 -> 2 -> 1 -> NULL
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode tmp = head.next;
        head.next = reverseList(head.next);

        return head;
    }

    /**
     * 迭代的实现
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedNode rnn = new ReverseLinkedNode();
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(rnn.reverseList2(head));
    }

}
