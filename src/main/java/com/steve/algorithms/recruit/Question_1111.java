package com.steve.algorithms.recruit;

import com.steve.algorithms.base.StrUtils;

/**
 * 1111. 有效括号的嵌套深度
 */
public class Question_1111 {

    public static void main(String[] args) {
        Question_1111 question = new Question_1111();
        String[] strs = {"flight", "flow", "flower"};
        int[] res = question.maxDepthAfterSplit("(()(())())");
        StrUtils.printArr(res);
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                res[i] = depth % 2;
            } else {
                res[i] = depth % 2;
                depth--;
            }

        }
        return res;
    }

}
