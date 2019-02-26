package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 8:19 2018/6/25
 * @Description: 两个单向链表，判断是否相交，相交的话返回第一个相交节点，不相交的话就返回null。
 * 思路： 这里面坑有点多，首先，判断单向链表是否相交，需要判断两个单向链表是否有环和无环，只有两个链表之一有环的条件下才能相交，
 * @Modified By:
 */
public class TwoListIntersect {
    static class Node{
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
        public void setNext(Node node){
            this.next = node;
        }
    }

    /**
     * 判断一个单向链表是否有环无环，有环返回环的第一个节点，无环返回null
     * 思路： 有两种方式，一种是借助hash表，一种是借助两个指针，一个快指针，一个慢指针。当两个指针相交的时候，快指针回到原点，此时快指针也变成慢指针，
     * 两个指针再次相交时就是第一个节点(非常玄学，可以用数学证明)。
     * @param head
     * @return 返回的节点不为空表示成环的第一个节点，为空表示不成环
     */
    public static Node hasLoopNode(Node head){
        Node tmp = null,n = head,fast = head.next.next,slow = head.next;
        boolean hasMeet = false;
        while (fast.next != null && fast.next.next != null){
            if(slow == fast){
                fast = n;
                hasMeet = true;
            }
            slow = slow.next;
            if(hasMeet){
                fast = n.next;
                n = n.next; // 能相遇，说明n.next一定不为空。
            }else{
                fast = fast.next.next;
            }
            if(hasMeet && slow == fast){
                tmp = slow; // 找到了，就返回
                break;
            }
        }
        return tmp;
    }

    /**
     * 两个无环单链表相交的问题，如果相交，则他们的尾节点必然相等。
     * 当相等时，不能立即判定两个单链表第一个相交的节点为尾节点。
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoopList(Node head1,Node head2){
        int len1 = 0,len2 = 0,differ = 0;
        Node tail1 = head1,tail2 = head2;
        int cur = 0;
        while (tail1.next != null){
            cur ++;
            tail1 = tail1.next;
        }
        while (tail2.next != null){
            cur --;
            tail2 = tail2.next;
        }
        if(tail1 != tail2){
            return null;
        }
        tail1 = cur > 0 ? head1 : head2;
        tail2 = tail1 == head1 ? head2 : head1;
        differ = Math.abs(len1-len2);
        while (differ > 0){
            differ --;
            tail1 = tail1.next;
        }
        while(tail1 != tail2){
            tail1 = tail1.next;
            tail2 = tail2.next;
        }
        return tail1;
    }

    /**
     * 两个有环链表相交的问题,有三种情况，
     * 一种是两个环都不想交。
     * 一种是共用一个环，相交的第一个节点在环前面的某个节点。
     * 一种是半公用一个环，可以是loop1，也可以是loop2
     * @param head1
     * @param head2
     * @return
     */
    public static Node doubleLoopList(Node head1,Node loop1 ,Node head2, Node loop2){
        if(loop1 == loop2){
            return noLoopList(construct(head1,loop1),construct(head2,loop2));
        }else{
            // 这个时候是另外两种情况了
            while(loop1 != null){
                if(loop1 == loop2){
                    return loop2;
                }
                loop1 = loop1.next;
            }
            // 两个有环链表不相交
            return null;
        }
    }

    private static Node construct(Node head, Node loop) {
        Node tmp = head;
        while(head != null){
            if(head == loop){
                head.next = null;
                break;
            }
            head = head.next;
        }
        return tmp;
    }

    public static void judgeListMeeting(Node head1,Node head2){
        // 首先判断两个链表有环或者无环
        Node loop1 = hasLoopNode(head1);
        Node loop2 = hasLoopNode(head2);
        Node result = null;
        // 两个都无环
        if(null == loop1 && null == loop2){
            System.out.println("两个链表为无环链表");
            result = noLoopList(head1,head2);
        }else if(loop1 != null && loop2 != null){
            System.out.println("两个链表为无环链表");
            result = doubleLoopList(head1,loop1,head2,loop2);
        }else{
            System.out.println("一个有环，一个无环");
        }
        if(result != null){
            System.out.println("第一个相交的节点的值为: "+result.value);
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(11);
        Node head1_5 = new Node(15);
        Node head1_4 = new Node(14,head1_5);
        Node head1_3 = new Node(13,head1_4);
        Node head1_2 = new Node(12,head1_3);
        head1.next = head1_2;
        head1_5.next = head1_3;

        Node head2 = new Node(21);
        Node head2_5 = new Node(25,null);
        Node head2_4 = new Node(24,head2_5);
        Node head2_3 = new Node(23,head2_4);
        Node head2_2 = new Node(22,head2_3);
        head2.next = head1_2;
        judgeListMeeting(head1,head2);
    }

}
