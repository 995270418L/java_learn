package com.steve.algorithms;

import lombok.Data;

@Data
public class ListNode {

    public static int val;
    public static ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
