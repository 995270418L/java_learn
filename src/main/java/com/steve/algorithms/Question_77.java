package com.steve.algorithms;

import com.google.common.collect.Lists;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Question_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, 1, n, k, new Stack<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int first, int n, int k, Stack<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=first; i<=n; i++){
            temp.push(i);
            backtrack(res, i+1, n, k, temp);
            temp.pop();
        }
    }

    public static void main(String[] args) {
        Question_77 question = new Question_77();
        System.out.println(question.combine(4, 2));
    }

}
