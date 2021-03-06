package com.steve.algorithms.repeat;

import com.steve.algorithms.base.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Question_3 {

    /**
     * 滑动窗口概念, 每个字符 最多 O(2n) 次 O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i =0, j=0, ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i =0, j=0, ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            j++;
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int i =0, j=0, ans = 0;
        int[] arr = new int[128];
        while (j < n) {
            i = Math.max(arr[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            arr[s.charAt(j)] = j + 1;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question_3 question = new Question_3();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l4.next = l5;
        l5.next = l6;

        System.out.println(question.lengthOfLongestSubstring3("abba"));
    }

}
