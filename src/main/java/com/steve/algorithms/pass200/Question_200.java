package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */
public class Question_200 {

    private int row;
    private int column;
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0) return res;
        row = grid.length;
        column = grid[0].length;
        for(int i=0; i< row; i++){
            for(int j=0; j< column; j++){
                if(grid[i][j] == '1'){
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j <0 || i>= row || j >= column || grid[i][j] == '0') return ;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
    }


    public static void main(String[] args) {
        Question_200 question = new Question_200();
        TreeNode root = new TreeNode(1);
        System.out.println(question.numIslands(null));
    }

}
