package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class Question_147 {

    public ListNode insertionSortList(ListNode head){
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;
        while (head != null && head.next != null){
            if(head.val <= head.next.val){
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val <= head.next.val) pre = pre.next;
            ListNode temp = head.next.next;
            head.next.next = pre.next;
            pre.next = head.next;
            head.next = temp;
        }
        return dummy.next;
    }

    /**
     * 指针值动节点不动， 效率太低
     * @param head
     * @return
     */
    public ListNode insertionSortList2(ListNode head){
        if(head == null) return null;
        ListNode p, q ;
        int temp;
        for(p = head;p != null;p = p.next){
            for(q = p.next;q != null;q = q.next){
                if(p.val > q.val){
                    temp = p.val;
                    p.val = q.val;
                    q.val = temp;
                }
            }
        }
        return head;
    }


    /**
     * 指针节点动值不动
     * @param head
     * @return
     */
    public ListNode insertionSortList1(ListNode head){
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode p , q;
        dummy.next = head;
        p = head.next;
        head.next = null;
        while (p != null){
            ListNode curr = p.next;
            q = dummy;
            while (q.next != null && p.val >= q.next.val) q = q.next;
            p.next = q.next;
            q.next = p;
            p = curr;
        }
        return dummy.next;
    }

    // 这方法着实巧妙，就是有点效率太低
    public ListNode insertionSortListReverse(ListNode head) {
        ListNode res = null;
        ListNode p = head;
        while (p != null){
            ListNode next = p.next;
            res = reverse(res, p);
            p = next;
        }
        return res;
    }

    /**
     *
     * @param head
     * @param node
     * @return
     */
    private ListNode reverse(ListNode head, ListNode node){
        if(head == null || head.val > node.val){
            node.next = head;
            return node;
        }
        head.next = reverse(head.next, node);
        return head;
    }

    public static void main(String[] args) {
        Question_147 question = new Question_147();
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(question.insertionSortList(l1));
    }

}
