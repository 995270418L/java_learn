package com.steve.algorithms.sword;


import com.steve.algorithms.base.ListNode;

public class Sword22 {

  public static void main(String[] args) {
    Sword22 sword14 = new Sword22();
    System.out.println(sword14.getKthFromEnd(null, 5));
  }

  public ListNode getKthFromEnd(ListNode head, int k) {

    int count = 0;
    ListNode pre = head;
    while (head != null){
      head = head.next;
      count ++;
    }
    int num = count - k + 1;
    while (num-- > 1){
      if(pre != null) {
        pre = pre.next;
      }
    }
    return pre;
  }

}
