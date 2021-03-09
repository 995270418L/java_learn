package com.steve.algorithms.sword;


import com.steve.algorithms.base.ListNode;


/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 */
public class Sword25 {

  public static void main(String[] args) {
    Sword25 sword14 = new Sword25();
    ListNode n1 = new ListNode(-9);
    ListNode n2 = new ListNode(3);
    n1.next = n2;
    ListNode n3 = new ListNode(5);
    ListNode n4 = new ListNode(7);
    n3.next = n4;
    System.out.println(sword14.mergeTwoLists(n1, n3));
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null) return null;
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (l1 != null || l2 != null){
      if(l1 == null){
        dummy.next = l2;
        l2 = l2.next;
      }else if(l2 == null){
        dummy.next = l1;
        l1 = l1.next;
      }else{
        if(l1.val > l2.val){
          dummy.next = l2;
          l2 = l2.next;
        }else{
          dummy.next = l1;
          l1 = l1.next;
        }
      }
      dummy = dummy.next;
    }
    return head.next;
  }

}
