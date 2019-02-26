package com.steve.cow_guest.classes.c5;

import java.util.Stack;

/**
 * 非递归的方式后序遍历二叉树的实现，只用一个栈
 */
public class UnRecurBehind {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value,Node left,Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 先回顾有两个栈的用法
     * @param head
     */
    public static void posOrderNonRecur(Node head){
        if(head == null){
            return ;
        }
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.peek();
        s1.push(head);
        while (!s1.isEmpty()){
            Node m = s1.pop();
            s2.push(m);
            if(m.left != null){
                s1.push(m.left);
            }
            if(m.right != null){
                s1.push(m.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.print(s2.pop().value + "\t");
        }
    }

    public static void posOrderNonRecur2(Node h){
        if(h == null){
            return ;
        }
        Stack<Node> tmp = new Stack();
        tmp.push(h);
        Node c= null;
        while (!tmp.isEmpty()){
            c = tmp.peek();
            if(c.left != null && h!= c.left && h != c.right ){
                tmp.push(c.left);
            }else if(c.right != null && h != c.right){
                tmp.push(c.right);
            }else{
                System.out.print(tmp.pop().value + "\t");
                h = c;
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        posOrderNonRecur2(n1);
    }
}
