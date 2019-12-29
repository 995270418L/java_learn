package com.steve.algorithms.pass300;

import com.steve.algorithms.base.ListNode;
import com.steve.algorithms.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单：
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 */
public class Question_203 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null){
            ListNode temp = head.next;
            if(temp.val == val){
                head.next = temp.next;
                continue;
            }
            head = head.next;
        }
        return dummy.next.val == val ? dummy.next.next : dummy.next;
    }

    public static void main(String[] args) {
        Question_203 question = new Question_203();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        System.out.println(question.removeElements(l1, 1));
    }

}
