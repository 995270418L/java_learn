package com.steve.algorithms.repeat.dp;

import java.util.ArrayList;
import java.util.List;

public class Question_120 {

    /**
     *每个 list 中找一个最小的数组成最小路径
     *
     *状态定义:
     *  dp[i][j] 表示第 i 个选择中选择 j 位置的数组成的结果为最小路径和
     *状态转移:
     *  dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + nums[j];
     *初始化:
     *  dp[0][0] = trignle[0][0];
     *  边界情况考虑:
     *  dp[i][0] 只能是上一行的第 0 个位置转换而来，所以 dp[i][0] 是前 i 个数字的累加和
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int len = triangle.size();
        int[][] dp = new int [len][len];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i<len; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        for(int i=1; i<len; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            min = Math.min(dp[len-1][i], min);
        }
        return min;
    }

    /**
     * 空间压缩:
     *  二维空间可以压缩成一维空间
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int len = triangle.size();
        int[] dp = new int [len];
        dp[0] = triangle.get(0).get(0);
        for(int i=1; i<len; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i < len ; i++){
            int j = triangle.get(i).size() - 1;
            for(; j > 0 ; j--){
                dp[j] = Math.min(dp[j-1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            min = Math.min(dp[i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        Question_120 question = new Question_120();
        List<Integer> list1 = new ArrayList<Integer>(){
            {
                add(2);
            }
        };
        List<Integer> list2 = new ArrayList<Integer>(){
            {
                add(3);
                add(4);
            }
        };
        List<Integer> list3 = new ArrayList<Integer>(){
            {
                add(6);
                add(5);
                add(7);
            }
        };
        List<Integer> list4 = new ArrayList<Integer>(){
            {
                add(4);
                add(1);
                add(8);
                add(3);
            }
        };
        List<List<Integer>> src = new ArrayList<>();
        src.add(list1);
        src.add(list2);
        src.add(list3);
        src.add(list4);
        System.out.println(question.minimumTotal2(src));
    }

}
