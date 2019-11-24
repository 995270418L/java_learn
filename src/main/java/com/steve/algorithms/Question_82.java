package com.steve.algorithms;

/**
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */
public class Question_82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode borrow = new ListNode(-1);
        borrow.next = head;

        ListNode slow = borrow;
        ListNode fast = head;
        while(fast != null){
            if((fast.next != null && fast.next.val != fast.val) || fast.next == null){
                if(slow.next == fast){  // 为了处理断层带来的影响加的一个判断.
                    slow = fast;
                }else{
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }
        return borrow.next;
    }

    public static void main(String[] args) {
        Question_82 question = new Question_82();
        System.out.println(question.deleteDuplicates(null));
    }

}
