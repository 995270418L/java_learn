package com.steve.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 */
public class Question_48 {

    /**
     * 转置 + 换行
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0) return;

        // transpose
        for(int i=0; i<m; i++){
            for(int j=i; j<m; j++){
                swap(matrix, i, j, j, i);
            }
        }

        // reverse each row
        for(int i=0; i< m; i++){
            for(int j=0; j<m/2; j++){
                swap(matrix, i, j, i, m-j-1);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int changeI, int changeJ){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[changeI][changeJ];
        matrix[changeI][changeJ] = temp;
    }

    public static void main(String[] args) {
        Question_48 question = new Question_48();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        question.rotate(matrix);
    }

}
