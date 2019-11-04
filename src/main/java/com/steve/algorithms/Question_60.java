package com.steve.algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 *
 *给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 */
public class Question_60 {

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        return backtrack(nums, visited, new ArrayList<>(), n, k);
    }

    public int factorial(int n){
        int res = 1;
        while(n > 0){
            res *= n;
            n --;
        }
        return res;
    }

    public String backtrack(int[] nums, boolean[] visited, List<String> pre, int n, int k){
        if(pre.size() == n){
            StringBuilder sb = new StringBuilder();
            for(String str : pre){
                sb.append(str);
            }
            return sb.toString();
        }
        int pc = factorial(n - 1 - pre.size());
        for(int i=0; i<n; i++){
            if(visited[i]){
                continue;
            }
            if(pc < k){
                k -= pc;
                continue;
            }
            visited[i] = true;
            pre.add(nums[i] + "");
            return backtrack(nums, visited, pre, n, k);
        }
        return null;
    }

    public static void main(String[] args) {
        Question_60 question = new Question_60();
        System.out.println(question.getPermutation(3, 4));
    }

}
