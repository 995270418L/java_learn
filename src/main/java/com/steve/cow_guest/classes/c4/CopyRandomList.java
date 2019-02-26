package com.steve.cow_guest.classes.c4;

import java.util.HashMap;

/**
 * @Author: steve
 * @Date: Created in 18:51 2018/6/18
 * @Description: 深度复制一个链表结构，用hash是最简单的，但如果时间复杂度要求为O(1)，就需要思考思考了
 * @Modified By:
 */
public class CopyRandomList {

    static class Node{
        int value;
        Node next;
        Node random;
        public Node(int value,Node next,Node random){
            this.value = value;
            this.next = next;
            this.random = random;
        }
    }

    //hash 方法
    public static Node copyRandomList(Node head){
        HashMap<Node,Node> map = generator(head);
        Node tmp = head;
        while(head != null) {
            map.get(head).next = head.next;
            map.get(head).random = head.random;
            head = head.next;
        }
        return map.get(tmp);
    }

    private static HashMap<Node,Node> generator(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        while(head != null){
            Node tmp = new Node(head.value,null,null);
            map.put(head,tmp);
            head = head.next;
        }
        return map;
    }

    // 非hash方法  1 -> 2 -> 3
    public static Node copyRandomList2(Node head){
        Node tmp = head; // 1 ->2 -> 3
        while(head != null){
            Node m = head.next; // m = 2
            Node newN = new Node(head.value,null,null);
            head.next = newN;  // 1 -> newN
            newN.next = m;     // newN -> 2
            head = m;          // 2
        }
        Node res = tmp.next;
        head = tmp;
        while( head != null){
            Node next = head.next.next;
            Node copyN = head.next;
            head.next = next;
            copyN.next = next == null ? null : next.next;
            copyN.random = head.random == null ? null : head.random.next;
            head = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node n3 = new Node(3,null,null);
        Node n2 = new Node(2,n3,null);
        Node n1 = new Node(1,n2,n3);
        // 打断点看结果
        Node tmp = copyRandomList2(n1);
    }
}
