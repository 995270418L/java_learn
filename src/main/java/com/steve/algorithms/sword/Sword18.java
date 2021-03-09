package com.steve.algorithms.sword;


import com.steve.algorithms.base.ListNode;

public class Sword18 {

  public static void main(String[] args) {
    Sword18 sword14 = new Sword18();
    ListNode n1 = new ListNode(4);
    ListNode n2 = new ListNode(5);
    ListNode n3 = new ListNode(1);
    n1.next = n2;
    n2.next = n3;
    System.out.println(sword14.deleteNode(n1, 5));
  }

  // 4 -> 5 -> 1  4
  public ListNode deleteNode(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode res = pre; // 赋予了pre节点的指针位置，当 pre 的值变化的时候，指针位置并没有变化。
    while (head != null){
      if(head.val == val){
        pre.next = head.next;
      }else{
        pre = pre.next;
      }
      head = head.next;
    }
    return res.next;
  }
}
