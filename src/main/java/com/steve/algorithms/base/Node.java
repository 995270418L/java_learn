package com.steve.algorithms.base;

import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {}


    public Node(int _val, List<Node> neighbors) {
        val = _val;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", neighbors=" + neighbors +
                '}';
    }
}
