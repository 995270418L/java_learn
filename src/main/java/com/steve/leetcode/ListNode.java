package com.steve.leetcode;

import lombok.Data;

@Data
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
