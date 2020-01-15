package com.steve.algorithms.pass300;


import com.steve.algorithms.base.ListNode;

/**
 * 简单:
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class Question_234 {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = head, prev = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prev;
            prev = pre;
        }
        if(fast != null){
            // 奇数链表
            slow = slow.next;
        }
        while (pre != null && slow != null){
            if(pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Question_234 question = new Question_234();
        ListNode r = new ListNode(1);
        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(1);

        r.next = r1;
        r1.next = r2;
        r2.next = r3;

        System.out.println(question.isPalindrome2(r));
    }

}
