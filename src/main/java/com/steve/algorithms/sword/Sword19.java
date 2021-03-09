package com.steve.algorithms.sword;


import com.steve.algorithms.base.ListNode;

/**
 * 字符串匹配，困难题，暂时不做
 */
public class Sword19 {

  public static void main(String[] args) {
    Sword19 sword14 = new Sword19();
    ListNode n1 = new ListNode(4);
    ListNode n2 = new ListNode(5);
    ListNode n3 = new ListNode(1);
    n1.next = n2;
    n2.next = n3;
    System.out.println(sword14.isMatch("string", "str"));
  }

  public boolean isMatch(String s, String p) {
    return false;
  }
}
