package com.steve.algorithms.recruit;

/**
 * 面试40: 最小的k个数
 */
public class Question_0107 {


    public static void main(String[] args) {
        Question_0107 question = new Question_0107();
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        question.printArr(arr);
//        question.rotate(arr);  // -2147483648
//        for(int i=0;i<arr.length; i++){
//            for(int j=0; j<arr[i].length; j++){
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }

    /**
     * 先旋转45度，在旋转45度
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length <= 0) return;
        int n = matrix.length;
        // 对角线划分
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 对称轴划分
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    /**
     * 回型打印矩阵的问题，
     *
     * @param arr
     */

    public void printArr(int[][] arr) {
        if (arr.length <= 0) return;
        int m = arr.length;
        int n = arr[0].length;
        int left = 0, right = n - 1, bottom = 0, top = m - 1;
        int total = m * n;
        int count = 0;
        while (left <= right && bottom <= top) {
            for (int i = left; i <= right; i++) {
                System.out.println(arr[bottom][i]);
                count++;
            }
            if (count == total) break;
            bottom++;
            for (int i = bottom; i <= top; i++) {
                System.out.println(arr[i][right]);
                count++;
            }
            if (count == total) break;
            right--;
            for (int i = right; i >= left; i--) {
                System.out.println(arr[top][i]);
                count++;
            }
            if (count == total) break;
            top--;
            for (int i = top; i >= bottom; i--) {
                System.out.println(arr[i][left]);
                count++;
            }
            if (count == total) break;
            left++;
        }
    }

}
