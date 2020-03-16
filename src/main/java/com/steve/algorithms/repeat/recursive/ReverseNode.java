package com.steve.algorithms.repeat.recursive;

import com.steve.algorithms.base.ListNode;

/**
 * 交换每两个相邻节点并返回其头节点
 */
public class ReverseNode {

    /**
     * 1 -> 2 -> 3 -> 4 -> 5  ===>>> 2 -> 1 -> 4 -> 3 -> 5
     * @param head
     * @return
     */
    public ListNode swap(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = head.next;
        head.next = swap(head.next.next);
        tmp.next = head;
        return tmp;
    }

    public static void main(String[] args) {
        ReverseNode reverseStr = new ReverseNode();
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        ListNode res = reverseStr.swap(head);
        System.out.println(res);
    }
}
