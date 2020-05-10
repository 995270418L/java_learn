package com.steve.algorithms.repeat.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.08. 有重复字符串的排列组合。 不是标准的回溯算法实现
 */
public class Question_0808 {

    private final List<String> res = new ArrayList();

    public static void main(String[] args) {
        Question_0808 question = new Question_0808();
        int[] arr = {1, 2, 3};
        String[] res = question.permutation("qqe");
        for (String str : res) {
            System.out.println(str);
        }
    }

    public String[] permutation(String S) {
        if (S == null || S.length() < 1) return new String[]{};
        backtrace(S.toCharArray(), 0);
        return res.toArray(new String[]{});
    }

    public void backtrace(char[] arr, int start) {
        if (start == arr.length - 1) {
            res.add(new String(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!same(arr, start, i)) {
                swap(arr, start, i);
                backtrace(arr, start + 1);
                swap(arr, start, i);
            }
        }
    }

    public boolean same(char[] arr, int start, int end) {
        for (; start < end; start++) {
            if (arr[start] == arr[end]) return true;
        }
        return false;
    }

    public void swap(char[] arr, int start, int end) {
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
