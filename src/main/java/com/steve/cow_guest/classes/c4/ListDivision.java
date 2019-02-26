package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 16:00 2018/6/18
 * @Description: 单向链表划分，小的数放左边，大的数放右边，等于的数放中间。空间复杂度O(1)
 * 思路：如果不要求空间复杂度的话，可以加个数组，将其化为荷兰国旗问题来解。要求空间复杂度的话，定义三个节点对象，
 * 分别是less，eq，more，默认都为空，首先遍历一遍链表，找到第一个比指定数num小的，设为less，同理eq和more也这样设定。
 * 第二次遍历，比num小的放在less后面(不和less地址相等)，同理其他三个也同样设定，最后将这几个依次相连即可。
 * @Modified By:
 */
public class ListDivision {

    static class Node{
        int value;
        Node next;
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 自己写的，有点乱，还是错的
     * @param head
     * @param num
     * @return
     */
    public static Node divisionList(Node head,int num) {
        // 6个变量，储存三个区域的最小最大值 t -> tail ; h -> head
        Node lh = null, lt = null, eh = null, et = null, mh = null, mt = null;
        // 第一次遍历，找出最大最小和相等的位置
        Node first = head;
        Node next = head;
        while (head != null) {
            if (head.value < num && lh == null) {
                lh = new Node(head.value, null);
            } else if (head.value == num && eh == null) {
                eh = new Node(head.value, null);
            } else if (head.value > num && mh == null) {
                mh = new Node(head.value, null);
            }
            next = head.next;

        }
        // 第二次遍历，丰富指针指向,这几个变量用于保证头节点不发生变化。
        Node tl = lh, te = eh, tm = mh;
        while (first != null) {
            if (first.value < num && lh != first) {
                lt = first;
                lh.next = lt;
                lh = lh.next;
            } else if (first.value == num && eh != first) {
                et = first;
                eh.next = et;
                eh = eh.next;
            } else if (first.value > num && mh != first) {
                mt = first;
                mh.next = mt;
                mh = mh.next;
            }
        }
        // 三个区域互相指向，形成新链表就是排序好了的链表
        if (lt != null && te != null) {
            lt.next = te;
        } else if (lt != null && te == null && tm != null) {
            lt.next = tm;
        }
        if (et != null && mh != null) {
            et.next = mh;
        }
        return tl;
    }

    /**
     * 左神写的，学习一下
     * @param head
     * @param num
     * @return
     */
    public static Node divisionList2(Node head,int num){
        Node lh = null, lt = null, eh = null, et = null, mh = null, mt = null;

        // 这个变量用来解耦链表每个节点
        Node next = head;

        // 给每个节点分区绑定变量
        while(head != null){
            next = head.next;
            head.next = null;  // 这样就把链表中每个节点单独提取出来了。
            if(head.value < num){
                if(lh == null){
                    lh = head;
                    lt = head;
                }else{
                    lt.next = head;
                    lt = head;
                }
            }else if(head.value == num){
                if(eh == null){
                    eh = head;
                    et = head;
                }else{
                    et.next = head;
                    et = head;
                }
            }else{
                if(mh == null){
                    mh = head;
                    mt = head;
                }else{
                    mt.next = head;
                    mt = head;
                }
            }
            head = next;
        }
        if(lt != null){
            lt.next = eh;
            et = et == null ? lt : et;
        }

        // 如果et == null,则et = lt，这里就成了 lt.next = mh;
        if(et != null){
            et.next = mh;
        }

        // 再返回首节点即可。
        return lh != null ? lh : eh != null ? eh : mh;
    }

    public static void main(String[] args) {
        Node n5 = new Node(1,null);
        Node n4 = new Node(2,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(6,n2);
        Node first = divisionList2(n1,5);
        while(first != null){
            System.out.print(first.value + "\t");
            first = first.next;
        }

    }

}
