package com.steve.algorithms.base;

import java.util.List;

public class Node2 {
    public int val;
    public List<Node2> neighbors;
    public Node2() {}


    public Node2(int _val, List<Node2> neighbors) {
        val = _val;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "val=" + val +
                ", neighbors=" + neighbors +
                '}';
    }
}
