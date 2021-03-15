package com.steve.algorithms.sword;


import com.steve.algorithms.base.Node;
import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sword35 {

  public static void main(String[] args) {
    Sword35 sword14 = new Sword35();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    System.out.println(sword14.copyRandomList(null));
  }

  /**
   * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
   * 还有一个 random 指针指向链表中的任意节点或者 null。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param head
   * @return
   */
  public Node copyRandomList(Node head) {
    if(head == null) return null;
    Map<Node, Node> map = new HashMap<>();
    Node cur = head;
    while (cur != null){
      map.put(cur, new Node(cur.val));
      cur = cur.next;
    }
    Node dum = head;
    while (dum != null){
      map.get(dum).next = map.get(dum.next);
      map.get(dum).random = map.get(dum.random);
      dum = dum.next;
    }
    return map.get(head);
  }

}
