package com.steve.algorithms.sword;

import com.steve.algorithms.base.ListNode;

/**
 * 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class Sword06 {

  public int[] reversePrint(ListNode head) {
    ListNode pre = null;
    int count = 0;
    while (head != null){
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
      count ++;
    }
    int[] res = new int[count];
    int i=0;
    while (pre != null){
      res[i++] = pre.val;
      pre = pre.next;
    }
    return res;
  }

  public static void main(String[] args) {
    Sword06 sword05 = new Sword06();
    ListNode head = new ListNode(1);
    ListNode head2 = new ListNode(3);
    ListNode head3 = new ListNode(2);
    head.next = head2;
    head2.next = head3;
    for(int a: sword05.reversePrint(head)){
      System.out.print(a);
    }
  }
}
