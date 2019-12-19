package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

/**
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 */
public class Question_143 {
    /**
     * 三个步骤：
     *  1: 链表重排序后, 末尾节点一定是中心节点，所以首先找到链表的中心节点（快慢指针）
     *  2: 按照中心节点分割链表，然后，右链表反转
     *  3: 右链表插入左链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightNode = slow.next;
        slow.next = null;
        // 右链表反转
        ListNode prev = null;
        while (rightNode != null){
            ListNode temp = rightNode.next;
            rightNode.next = prev;
            prev = rightNode;
            rightNode = temp;
        }
        // 右链表插入左链表
        ListNode dummy = head;
        while (prev != null){
            ListNode dNext = dummy.next;
            ListNode pNext = prev.next;
            dummy.next = prev;
            prev.next = dNext;
            prev = pNext;
            dummy = dummy.next.next;
        }
    }

    public static void main(String[] args) {
        Question_143 question = new Question_143();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        question.reorderList(l1);
        System.out.println("over");
    }

}
