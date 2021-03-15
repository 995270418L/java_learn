package com.steve.algorithms.base;

public class Node {

    public int val;
    public Node next;
    public Node random;
    public Node() {}

    public Node(int _val){
        val = _val;
    }

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }

}
