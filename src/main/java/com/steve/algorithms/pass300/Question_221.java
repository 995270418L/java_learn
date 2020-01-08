package com.steve.algorithms.pass300;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
public class Question_221 {

    /**
     * 先看暴力枚举法
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int maxSqlen = 0;
        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(matrix[i][j]== '1'){
                    int sqlen = 0;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag){
                        // 先下后右
                        for(int k=j; k<=sqlen + j; k++){
                            if(matrix[i + sqlen][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        // 先右后下
                        for(int k = i; k<= sqlen + i; k++){
                            if(matrix[k][j + sqlen] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) sqlen ++;
                    }
                    maxSqlen = Math.max(maxSqlen, sqlen);
                }
            }
        }
        return maxSqlen * maxSqlen;
    }

    /**
     * 动态规划
     * dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     *
     * dp[i][j]意思应该是表示 在左上角矩阵中由matrix[i-1][j-1]参与构成的最大正方形边长
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix){
        if(matrix.length <= 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int maxSqlen = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSqlen = Math.max(maxSqlen, dp[i][j]);
                }
            }
        }
        return maxSqlen * maxSqlen;
    }

    public static void main(String[] args) {
        Question_221 question = new Question_221();
//        System.out.println(question.containsNearbyAlmostDuplicate2(new int[]{1,5,9,1,5,9},2, 3));
        System.out.println(question.maximalSquare2(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'}, {'1','0','0','1','0'}}));
    }

}
