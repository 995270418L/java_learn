package com.steve.algorithms;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 */
public class Question_86 {

    /**
     * 双指针法
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummyBefore = new ListNode(-1);
        ListNode dummyBeforeHead = dummyBefore;
        ListNode dummyAfter = new ListNode(-1);
        ListNode dummyAfterHead = dummyAfter;
        while(head != null){
            if(head.val < x){
                dummyBefore.next = head;
                dummyBefore = dummyBefore.next;
            }else{
                dummyAfter.next = head;
                dummyAfter = dummyAfter.next;
            }
            head = head.next;
        }
        // 清空两个节点的后续
        dummyBefore.next = null;
        dummyAfter.next = null;
        // 合并两个节点
        dummyBefore.next = dummyAfterHead.next;
        return dummyBeforeHead.next;
    }

    public static void main(String[] args) {
        Question_86 question = new Question_86();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode res = question.partition(node1,3);
        System.out.println(res);
    }

}
