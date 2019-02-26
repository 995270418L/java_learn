package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 8:08 2018/6/18
 * @Description: 判断链表是否为回文串  比如：
 *  1 -> 2 -> 3 -> 2 -> 1
 *  15 -> 6 -> 15
 *  如果要求空间复杂度为O(1)的话(面试),可以用两个指针，一个步长为2，一个为1.当2的结束时，1的位于中间部分。
 *  反转剩余的部分链表内容，和链表开头的数据比较，相同返回true,否则返回false.最后再将链表反转回来。
 *  比试中一般都不要求空间复杂度，可以用栈保存链表数据，弹出来的顺序即链表的反序。
 *  这里用O(1)的方法
 * @Modified By:
 */
public class judgeReverseList {

    static class Node{
        int value;
        Node next;
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 1 -> 2
     * 反转链表的具体实现函数
     * @param root
     */
    private static Node reverseList(Node root){
        Node next , prev=null;
        while(root != null){
            next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        return prev;
    }

    private static boolean findMid2(Node head){
        // 先找寻链表的中间位置,记为slow变量
        Node slow = head,fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 改变自slow变量后面的节点指向，反转链表,返回反转的头节点。
        Node revF = reverseList(slow);
        // 这个临时变量是来保证能将反序节点再反转回去。
        Node tmp = revF;
        // 判断是否是回文串
        boolean result = true;
        while(revF != null && head != null){
            if(revF.value != head.value){
                result = false;
                break;
            }
            revF = revF.next;
            head = head.next;
        }
        //无论结果与否，将反转回来的再反转回去
        reverseList(tmp);
        return result;
    }

    public static void main(String[] args) {
        Node n5 = new Node(1,null);
        Node n4 = new Node(2,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        boolean result = findMid2(n1);
        System.out.println(result);
        while(result && n1 != null){
            System.out.print(n1.value + "\t");
            n1 = n1.next;
        }
    }
}
