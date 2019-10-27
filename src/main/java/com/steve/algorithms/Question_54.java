package com.steve.algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 *
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Question_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;
        int u=0, d=matrix.length-1, l=0, r=matrix[0].length-1;
        while (true){
            // 向右
            for(int i=l; i<=r; i++) res.add(matrix[u][i]);
            if(++u > d) return res;
            // 向下
            for(int i=u; i<=d; i++) res.add(matrix[i][r]);
            if( --r < l) return res;
            // 向右
            for(int i=r; i>=l; i--) res.add(matrix[d][i]);
            if(--d < u) return res;
            // 向上
            for(int i=d; i>=u; i--) res.add(matrix[i][l]);
            if(++l > r) return res;
        }
    }


    public static void main(String[] args) {
        Question_54 question = new Question_54();
        System.out.println(question.spiralOrder(new int[][]{{1,2,3,5},{4,6,7,9}}));
    }

}
