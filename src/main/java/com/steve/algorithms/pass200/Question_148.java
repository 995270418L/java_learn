package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

/**
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 */
public class Question_148 {

    /**
     * 归并排序
     *
     *归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
     *需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
     *排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
     *法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
     *慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
     *较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
     *直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
     *
     *主要考察3个知识点，
     * 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null :mergeSort(head);
    }

    private ListNode mergeSort(ListNode node){
        if(node.next == null) return node;
        ListNode fast = node, slow = node, rightNode = null;
        while (fast != null && fast.next != null){
            rightNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        rightNode.next = null;
        ListNode l = mergeSort(node);
        ListNode r = mergeSort(slow);
        return mergeSort(l, r);
    }

    private ListNode mergeSort(ListNode l, ListNode r){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l != null && r != null){
            if(l.val <= r.val){
                curr.next = l;
                l = l.next;
            }else{
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if(l != null){
            curr.next = l;
        }
        if(r != null){
            curr.next = r;
        }
        return dummy.next;
    }

    /**
     * 快排版本， 耗时太长了
     * @param head
     * @return
     */
    public ListNode sortListQuickLy(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return quickSort(dummy, null);
    }

    public ListNode quickSort(ListNode left, ListNode end){
        if(left.next == end) return left;
        // temp 为临时链表，目的是 partition
        ListNode temp = new ListNode(0);
        ListNode partition = left.next, p = partition, tp = temp ;
        while (p.next != end){
            if(p.next.val < partition.val){
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        tp.next = left.next;
        left.next = temp.next;
        quickSort(left, partition);
        quickSort(partition, end);
        return left.next;
    }


    public static void main(String[] args) {
        Question_148 question = new Question_148();
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(question.sortListQuickLy(l1));
    }

}
