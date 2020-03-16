package com.steve.algorithms.fight;

/**
 * 二维数组中的查找
 */
public class Question_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        for(int i=0; i<m; i++){
            if(matrix[i][0] <= target && matrix[i][n-1] >= target){
                if(binarySearch(matrix[i], target)) return true;;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target){
        int end = nums.length - 1;
        int start = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Question_04 question = new Question_04();
        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(question.findNumberIn2DArray(matrix, 20));
    }
}
