package com.steve.algorithms.repeat.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全组合的实现
 */
public class Question_fff {

    private final List<String> res = new ArrayList();

    public static void main(String[] args) {
        Question_fff question = new Question_fff();
        int[] arr = {1, 2, 3};
        String[] res = question.permutation("abc");
        for (String str : res) {
            System.out.println(str);
        }
    }

    public String[] permutation(String S) {
        if (S == null || S.length() < 1) return new String[]{};
        int len = S.length();
        int n = 1 << len;
        for (int i = 1; i < n; i++) {  // 2 ^ n - 1,                  1,2,3,4,5,6,7
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                int tmp = 1 << j;
                if ((i & tmp) != 0) {
                    sb.append(S.charAt(j));
                }
            }
            res.add(sb.toString());
        }
        return res.toArray(new String[]{});
    }
}
