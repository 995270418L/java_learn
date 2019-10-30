package com.steve.algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 *
 */
public class Question_59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l=0, r=n-1, u=0, d = n-1;
        int num = 1;
        while (num <= n * n){
            // 向右
            for(int i=l; i<=r; i++) res[u][i] = num++;
            if(++u > d) return res;
            // 向下
            for(int i=u; i<=d; i++) res[i][r] = num++;
            if( --r < l) return res;
            // 向右
            for(int i=r; i>=l; i--) res[d][i] = num++;
            if(--d < u) return res;
            // 向上
            for(int i=d; i>=u; i--) res[i][l] = num++;
            if(++l > r) return res;
        }
        return res;
    }

    public static void main(String[] args) {
        Question_59 question = new Question_59();
        System.out.println(question.generateMatrix(3));
    }

}
