package com.steve.algorithms.company.bytedance;

/**
 * 字符串反转
 */
public class ReverseWord {

    public static void main(String[] args) {
        ReverseWord cm = new ReverseWord();
        System.out.println(cm.reverseWords("  "));
    }

    public String reverseWords(String s) {
        if (s.trim().length() <= 0) return "";
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals("")) continue;
            sb.append(arr[i]).append(" ");
        }
        String res = sb.toString();
        return res.substring(0, sb.length() - 1);
    }

}
