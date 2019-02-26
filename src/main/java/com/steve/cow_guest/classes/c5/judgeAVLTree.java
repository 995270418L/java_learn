package com.steve.cow_guest.classes.c5;

import com.steve.cow_guest.classes.c5.BtSerialize.Node;

/**
 * 判断一棵树是否为平衡二叉树（AVL）:  左子树和右子树的高度相差不超过1
 * 思路： 递归，返回一个int值，当某个节点为null时，返回0，表示该子树是一颗平衡二叉树。左右高度不相等，返回-1，表明不是一颗平衡二叉树。
 **/
public class judgeAVLTree {

    public static int isAvl(Node head){
        if(head == null){
            return 0;
        }
        int left = isAvl(head.left);
        if(left == -1){
            return -1;
        }
        int right = isAvl(head.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        Node h6 = new Node(6);
        Node h7 = new Node(7);
        h1.left = h2;
        h2.left = h4;
        h3.left = h6;
        h3.right = h7;
        System.out.println(isAvl(h1) == -1 ? "false" : "true");
    }

}
