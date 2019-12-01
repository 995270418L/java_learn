package com.steve.algorithms.pass100;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 *
 */
public class Question_73 {


    public void setZeroes(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        boolean isRow = false;
        for(int i=0; i<rLen; i++){
            if(matrix[i][0] == 0){
                isRow = true;
            }
            for(int j=1; j<cLen; i++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 对第一行和第一列不做处理
        for(int i=1; i<rLen; i++){
            for(int j=1; j<cLen; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if(matrix[0][0] == 0){
            for(int i=0; i<cLen ; i++){
                matrix[0][i] = 0;
            }
        }
        if(isRow){
            for(int i=0; i<rLen; i++){
                matrix[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        Question_73 question = new Question_73();
        int[][] a = new int[3][];
        question.setZeroes(a);
        System.out.println();
    }

}
