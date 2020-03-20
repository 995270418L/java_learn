package com.steve.algorithms.repeat.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 杨辉三角
 */
public class PasacTriangle {

    private int[][] dp;

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        dp = new int[numRows][numRows];
        System.out.println(dp.length);
        for(int i=0 ;i<numRows; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j <= i; j++){
                int value = helper(i, j);
                dp[i][j] = value;
                tmp.add(value);
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<>();
        dp = new int[rowIndex+1][rowIndex+1];
        for(int j=0; j <= rowIndex; j++){
            tmp.add(helper(rowIndex, j));
        }
        return tmp;
    }

    /**
     * 生成第 i 行， 第 j 列的数据
     * @param row
     * @param j
     * @return
     */
    public int helper(int row, int j){
        if(row == 0){
            return 1;
        }
        if(dp[row][j] != 0) return dp[row][j];
        if(j == 0 || j == row) {
            return 1;
        }else{
            int left = helper(row - 1, j - 1);
            dp[row-1][j-1] = left;
            int right = helper(row - 1, j);
            dp[row-1][j] = right;
            return left + right;
        }
    }

    public static void main(String[] args) {
        PasacTriangle question = new PasacTriangle();
//        System.out.println(question.generate(30)); // 超出时间限制
        System.out.println(question.getRow(4));
    }
}