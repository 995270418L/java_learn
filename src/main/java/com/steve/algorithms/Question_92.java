package com.steve.algorithms;

import com.steve.algorithms.base.ListNode;

/**
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class Question_92 {

    /**
     * 3 指针完成交换
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode cur = head;
        while(m > 1){
            prev = cur;
            cur = prev.next;
            m --;
            n--;
        }
        ListNode con=prev, tail=cur;
        while(n > 0){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            n--;
        }
        if(con != null){
            con.next = prev;
        }else{
            head = prev;
        }
        tail.next = cur;
        return head;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            if(prev == null){
                prev = head;
                cur = prev.next;
                prev.next = null;
            }else{
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        Question_92 question = new Question_92();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        ListNode head2 = new ListNode(3);
        head1.next = head2;
        ListNode head3 = new ListNode(4);
        head2.next = head3;
        ListNode head4 = new ListNode(5);
        head3.next = head4;

        int[] nums1 = {1,2,2};
        String s = "226";
        System.out.println(question.reverseList(head));
    }

}
