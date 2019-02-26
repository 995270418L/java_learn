package com.steve.leetcode;

public class Soulution1 {

    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i< nums.length; i++){
            for(int j=i+1;j<nums.length; j++){
                if( (i + j) == target) {
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        new Solution().addTwoNumbers(l1,l2);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = null;
            if (l1 != null){
                head = new ListNode(l1.val);
            }else if(l2 != null){
                head = new ListNode(l2.val);
            }else {
                return null;
            }
            ListNode tmpHead = head;

            int forward = 0;
            while(l1 != null || l2 != null){
                int a = (l1 == null ? 0 : l1.val ) + (l2 == null ? 0 : l2.val);
                if (a >= 10){
                    a %= 10;
                    forward = 1;
                }else{
                    if (forward == 1){
                        a += 1;
                        forward = 0;
                    }
                }
                ListNode tmp =  new ListNode(a);
                tmpHead.next = tmp;
                tmpHead = tmp;
                if (l1.next != null){
                    l1 = l1.next;
                }else {
                    l1 = null;
                }
                if(l2.next != null){
                    l2 = l2.next;
                }else{
                    l2 = null;
                }
            }
            return head;
        }

    }
}
