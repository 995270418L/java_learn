package com.steve.ifeve.multipartline;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liu on 4/9/17.
 */
public class Main {

    public static void main(String... args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i + 1, i);
        }
    }

    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    /**
     * 随机数生成器
     *
     * @param y
     * @return
     */
    public static int xorShift(int y) {
        y ^= (y << 6);   // y = y ^ (y * 2^6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

}
