package com.steve.algorithms.pass300;

import java.util.*;

/**
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class Question_216 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new ArrayDeque<>();

    /**
     * 回溯法
     * @param k 数量
     * @param n 和
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(1, k, n);
        return res;
    }

    public void backtrace(int start, int k, int n){
        if(k < 0 || n <0) return;
        if(k == 0 && n == 0) {
            res.add(new ArrayList<>(path));
        }
        for(int i=start; i< 10; i++){
            path.push(i);
            backtrace(i + 1, k-1, n - i);
            path.pop();
        }
    }

    public static void main(String[] args) {
        Question_216 question = new Question_216();
        System.out.println(question.combinationSum3(3, 7));
    }

}
