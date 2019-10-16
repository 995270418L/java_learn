package com.steve.algorithms;


/**
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Question_19 {

    /**
     * 两次遍历法，添加一个临时节点节省许多代码俩和边界判断
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lenHead = head;
        int len = 0;
        while(lenHead != null){
            len ++;
            lenHead = lenHead.next;
        }
        len -= n;
        lenHead = dummy;
        while (len > 0){
            len --;
            lenHead = lenHead.next;
        }
        lenHead.next = lenHead.next.next;
        return dummy.next;
    }

    /**
     * 一次遍历法， 使用两个指针
     * @param head  1 >> 1, 2 >> 1, 2, 3, 4, 5
     * @param n
     * @return
     */
    public ListNode removeNthFromEndOne(ListNode head, int n) {
        if(head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        while( n >= 0){
            n --;
            if(first == null){
                return dummy.next;  //如果n越界了，直接返回dummy.next即可。
            }
            first = first.next;
        }
        while(first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;  // 如果这里返回head的话，head有可能被删了。
    }


    public static void main(String[] args) {
        Question_19 question = new Question_19();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(question.removeNthFromEndOne(node1, 2));
    }

}
