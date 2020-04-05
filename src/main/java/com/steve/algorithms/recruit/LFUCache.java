package com.steve.algorithms.recruit;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU缓存
 * <p>
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
 * <p>
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 */
public class LFUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public static void main(String[] args) {
        LFUCache question = new LFUCache(4);
        String[] strs = {"flight", "flow", "flower"};
        System.out.println(question.get(1));
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node v = map.get(key);
            remove(v);
            setHead(v);
            return v.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node v = map.get(key);
            v.value = value;
            remove(v);
            setHead(v);
        } else {
            Node v = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(key, v);
            setHead(v);
        }
    }

    private void setHead(Node node) {
        if (head != null) {
            head.pre = node;
            node.next = head;
        } else {
            head = node;
        }
    }

    private void remove(Node node) {
        Node pre = node.pre;
        if (pre != null) {
            pre.next = node.next;
        } else {
            head = node.next;
        }
        Node next = node.next;
        if (next != null) {
            next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
