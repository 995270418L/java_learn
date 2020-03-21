package com.steve.algorithms.repeat.recursive;

import com.steve.algorithms.base.ListNode;

/**
 * 合并两个有序链表
 */
public class MergeListSorted {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        if(l1.val > l2.val){
            head = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }else{
            head = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(8);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
        MergeListSorted mergeListSorted = new MergeListSorted();
        System.out.println(mergeListSorted.mergeTwoLists(l1, l2));
    }

}
