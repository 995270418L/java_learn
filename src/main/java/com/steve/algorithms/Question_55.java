package com.steve.algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 */
public class Question_55 {

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
        Question_55 question = new Question_55();
        System.out.println(question.spiralOrder(new int[][]{{1,2,3,5},{4,6,7,9}}));
    }

}
