package com.steve.algorithms.pass200;

import com.steve.algorithms.base.Node;

import java.util.*;

/**
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 *
 *
 */
public class Question_120 {

    /**
     * DP O(n) 不修边幅的 DP
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() <=0 ) return 0;
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=triangle.size() - 1; i >=0; i--){
            dp[triangle.size()-1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i=triangle.size() - 2; i >= 0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * DP O(n) 不修边幅的 DP
     * @param triangle
     * @return
     */
    public int minimumTotalOptimazation(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() <=0 ) return 0;
        int[] temp = new int[triangle.size()];
        for(int i=triangle.size() - 1; i >=0; i--){
            temp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i=triangle.size() - 2; i >= 0; i--){
            for(int j=0; j<=i; j++){
                temp[j] = Math.min(temp[j], temp[j+1]) + triangle.get(i).get(j);
            }
        }
        return temp[0];
    }

    public static void main(String[] args) {
        Question_120 question = new Question_120();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);
        System.out.println(question.minimumTotalOptimazation(res));
    }

}
