package com.steve.algorithms.recruit;

import com.steve.algorithms.base.ListNode;

/**
 *
 * 876. 链表的中间结点
 *
 */
public class Question_876 {

    public ListNode middleNode(ListNode head) {
        return helper(head, head);
    }

    public ListNode helper(ListNode fast, ListNode slow){
        if(fast.next == null){
            return slow;
        }
        if(fast.next.next == null){
            return slow.next;
        }
        return helper(fast.next.next, slow.next);
    }

    public static void main(String[] args) {
        Question_876 question = new Question_876();
        String[] arr = {"cat","bt","hat","tree"};
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(6);

        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        System.out.println(question.middleNode(head));
    }

}
