package com.steve.cow_guest.classes.c5;

import com.steve.cow_guest.classes.c5.BtSerialize.Node;

import java.util.Stack;

/**
 * 判断是否是搜索二叉树: 右边的节点比父节点大，左边的节点比父节点小.
 * 思路: 中序遍历排序判断,后面的数比前面的数大或者相等(非递归的方式效率更高)
 */
public class judgeSBT {

    public static int isSbt(Node head){
        if(head == null){
            return -1;
        }
        Stack<Node> s = new Stack();
        int last = Integer.MIN_VALUE;
        Node tmp = head;
        while (tmp != null || !s.isEmpty()){
            while (tmp != null){
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.isEmpty()){
                tmp = s.pop();
                if(tmp.value < last){
                    return -1;
                }else{
                    last = tmp.value;
                }
                tmp = tmp.right;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Node h1 = new Node(4);
        Node h2 = new Node(2);
        Node h3 = new Node(6);
        Node h4 = new Node(1);
        Node h5 = new Node(3);
        Node h6 = new Node(5);
        Node h7 = new Node(7);
        h1.left = h2;
        h1.right = h3;
        h2.left = h4;
        h2.right = h5;
        h3.left = h6;
        h3.right = h7;

        System.out.println(isSbt(h1) > 0 ? "true" : "false");
    }

}
