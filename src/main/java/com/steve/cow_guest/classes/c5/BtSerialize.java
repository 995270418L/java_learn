package com.steve.cow_guest.classes.c5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 */
public class BtSerialize {

    public static class Node{
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
     * 先序遍历序列化
     * @param node
     * @return
     */
    public static String serialize(Node node){
        if(node == null){
            return "#_";
        }
        String s = node.value + "_";
        s += serialize(node.left);
        s += serialize(node.right);
        return s;
    }

    /**
     * 反序列化
     * @param str
     * @return
     */
    public static Node reSerialize(String str){
        if(null == str && str.trim().length() == 0){
            return null;
        }
        String[] result = str.split("_");
        Queue<String> queue = new LinkedList();
        for(String s : result){
            queue.add(s);
        }
        return dealWithQueue(queue);
    }

    /**
     * 为什么要用队列这个数据结构，因为递归方便。
     * @param queue
     * @return
     */
    private static Node dealWithQueue(Queue<String> queue) {
        String s = queue.poll();
        if(s.equals("#")){
            return null;
        }
        Node node = new Node(Integer.valueOf(s));
        node.left = dealWithQueue(queue);
        node.right = dealWithQueue(queue);
        return node;
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
        h1.right = h3;
        h2.left = h4;
        h2.right = h5;
        h3.left = h6;
        h3.right = h7;
        String str = serialize(h1);
        Node node = reSerialize(str);
        System.out.println(node.value);
    }

}
