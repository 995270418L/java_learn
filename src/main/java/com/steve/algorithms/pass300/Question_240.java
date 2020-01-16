package com.steve.algorithms.pass300;


/**
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 */
public class Question_240 {

    /**
     * 逻辑搜索法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int rows = matrix.length - 1;
        int cols = 0;
        // 从最后一行的第一个元素开始查找
        while (rows >= 0 && cols < matrix[0].length){
            if(matrix[rows][cols] > target){
                rows --;
            }else if(matrix[rows][cols] < target){
                cols ++;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 二分搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int shortDim = Math.min(matrix.length, matrix[0].length);
        for(int i=0; i< shortDim; i++){
            if(binarySearch(matrix, target, i, true) || binarySearch(matrix, target, i, false)){
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int start, boolean vertical){
        int low = start;
        int end = vertical ? matrix.length - 1 : matrix[0].length - 1;
        while (end >= low){
            int mid = end - (end - low) / 2;
            if(vertical){
                if(matrix[mid][start] > target){
                    end = mid - 1;
                }else if(matrix[mid][start] < target){
                    low = mid + 1;
                }else{
                    return true;
                }
            }else{
                if(matrix[start][mid] > target){
                    end = mid - 1;
                }else if(matrix[start][mid] < target){
                    low = mid + 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question_240 question = new Question_240();
        int[][] src = new int[1][1];
        src[0][0] = 1;
        System.out.println(question.searchMatrix2(src, 1));
    }

}
