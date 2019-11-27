package com.steve.algorithms;

import com.steve.algorithms.base.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 *
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
public class Question_61 {

    /**
     *  思路： 先将链表闭合成环， 然后在适当的位置断开，就成了新链表了
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return new ListNode(0);
        }
        int n = 1;
        ListNode first = head;
        // 全链表
        while(head.next != null){
            n ++;
            head = head.next;
        }
        head.next = first;
        int location = n - (k % n) + 1;
        while(location > 1){
            first = first.next;
            location --;
        }
        ListNode res = first.next;
        first.next = null;
        return res;
    }


    public static void main(String[] args) {
        Question_61 question = new Question_61();
        System.out.println(question.rotateRight(null, 2));
    }

}
