package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;
import com.steve.leetcode.ListNode;

/**
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class Question_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode mid = findMiddle(head);
        TreeNode node = new TreeNode(mid.val);
        if(head == mid){
            return node;
        }
        node.left = sortedListToBST(head);
        node.right= sortedListToBST(mid.next);
        return node;
    }

    /**
     * 找寻链表的中点
     * @param head
     * @return
     */
    public ListNode findMiddle(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null; // 断开链表
        }
        return slow;
    }

    public static void main(String[] args) {
        Question_109 question = new Question_109();
        TreeNode tmp = new TreeNode(1);
        TreeNode tmp2 = new TreeNode(2);
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp4 = new TreeNode(4);
        TreeNode tmp5 = new TreeNode(5);
        TreeNode tmp6 = new TreeNode(6);
        tmp.left = tmp2;
        tmp.right = tmp3;
        tmp2.left = tmp4;
        tmp2.right = tmp5;
        tmp3.left = tmp6;

        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        node1.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode node5 = new ListNode(9);
        node4.next = node5;
        System.out.println(question.sortedListToBST(node1));
    }

}
