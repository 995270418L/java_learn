package com.steve.algorithms.repeat.dp;

import java.util.List;

public class Question_120 {

    /**
     *每个 list 中找一个最小的数组成最小路径
     *状态定义:
     *  dp[i][j] 表示前 i 个选择中选择 j 位置的数组成的路径和最小
     *状态转移:
     *  dp[i][j] = dp[i-1][j] + Math.min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
     *初始化:
     *  dp[]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int len = triangle.size();
        if(len == 0) return 0;
        int ll = triangle.get(len - 1).size();
        int[][] memo = new int[len][ll];
        memo[0][0] = triangle.get(0).get(0);
        for(int i=1; i<len; i++){

        }
        return 0;
    }

    public static void main(String[] args) {
        Question_120 question = new Question_120();
        System.out.println(question.minimumTotal(null));
    }

}
