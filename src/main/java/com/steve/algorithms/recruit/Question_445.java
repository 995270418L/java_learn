package com.steve.algorithms.recruit;

import com.steve.algorithms.base.ListNode;

/**
 * 最长公共子串
 */
public class Question_445 {

    public static void main(String[] args) {
        Question_445 question = new Question_445();
        String[] strs = {"flight", "flow", "flower"};
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(6);
        ListNode l13 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;
        System.out.println(question.addTwoNumbers(l1, l11));
    }

    /**
     * 解法一： 反转链表然后相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        boolean flag = false;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null || l2 != null || flag) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + (flag ? 1 : 0);
            flag = sum / 10 > 0;
            ListNode tmp = new ListNode(sum % 10);
            head.next = tmp;
            head = tmp;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode root) {
        ListNode prev = null;
        while (root != null) {
            ListNode tmp = root.next;
            root.next = prev;
            prev = root;
            root = tmp;
        }
        return prev;
    }

}
