package com.steve.algorithms.recruit;

import java.util.ArrayList;
import java.util.List;

/**
 * 42. 接雨水
 */
public class Question_22 {

    public static void main(String[] args) {
        Question_22 question = new Question_22();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(question.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String cur, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > right) return;  // 剪枝
        if (left > 0) {
            dfs(cur + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(cur + ")", left, right - 1, res);
        }
    }

}
