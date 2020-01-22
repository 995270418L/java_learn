package com.steve.algorithms.repeat;

import com.steve.algorithms.base.ListNode;

public class Question_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        boolean flag = false;
        ListNode head = dummy;
        while (l1 != null || l2 != null || flag){
            int first = l1 != null ? l1.val : 0;
            int sec = l2 != null ? l2.val : 0;
            int sum = first + sec;
            sum += flag ? 1 : 0;
            ListNode newNode = new ListNode(sum % 10);
            if(sum / 10 > 0){
                flag = true;
            }else{
                flag = false;
            }
            dummy.next = newNode;
            dummy = dummy.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Question_2 question = new Question_2();
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


        System.out.println(question.addTwoNumbers(l1, l4));
    }

}
