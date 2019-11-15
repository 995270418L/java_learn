package com.steve.algorithms;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 */
public class Question_74 {


    /**
     * 一步二分法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixOne(int[][] matrix, int target){
        int row = matrix.length;
        if(row <= 0) return false;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1, mid;
        while(left <= right){
            mid = right - (right - left) / 2;
            int tmp = matrix[mid / col][mid % col];
            if(tmp == target){
                return true;
            }else if(tmp > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
    /**
     * 分步二分法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        boolean res = false;
        for(int i=0; i< row; i++){
            res = searchOne(matrix[i], target);
            if(res) return res;
        }
        return res;
    }

    public boolean searchOne(int[] matrix, int target){
        if(target >= matrix[0] && target <= matrix[matrix.length - 1]){
            // 二分法
            return partSearch(matrix, target);
        }else{
            return false;
        }
    }

    public boolean partSearch(int[] matrix, int target){
        int start = 0, end=matrix.length -1, mid;
        while(start <= end){
            mid = end - (end-start) / 2;
            if(matrix[mid] == target){
                return true;
            }else if(matrix[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Question_74 question = new Question_74();
        int[][] a = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[][] b = {{1}};
        System.out.println(question.searchMatrixOne(b, 1));
    }

}
