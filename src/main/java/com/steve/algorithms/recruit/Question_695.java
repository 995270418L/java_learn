package com.steve.algorithms.recruit;

import com.steve.algorithms.base.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最大岛屿面积
 */
public class Question_695 {

    /**
     * 暴力枚举法，枚举以每个点为起点出发得到的岛屿面积
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length <= 0) return 0;
        int mRow = grid.length;
        int mCol = grid[0].length;
        int max = 0;
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mCol; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, islandArea(grid, i, j));
                }
            }
        }
        return max;
    }

    private final int[] ex = {-1, 1, 0, 0};                       // 上、下、左、右
    private final int[] ey = {0, 0, -1, 1};                       // 上、下、左、右

    /**
     * 扩展性周边遍历 BFS, 使用队列，周边扩展
     */
    public int islandArea(int[][] grid, int row, int col) {
        int area = 0;
        int mRow = grid.length;
        int mCol = grid[0].length;
        int[][] used = new int[mRow][mCol];
        Queue<Pair> queue = new LinkedList<>();
        Pair<Integer,Integer> first = new Pair<>(row, col);
        queue.add(first);
        used[row][col] = 1;
        while(!queue.isEmpty()){
            Pair<Integer, Integer> pair = queue.poll();
            area ++;
            for(int i=0; i<4; i++){
                int tRow = pair.getKey() + ex[i];
                int tCol = pair.getValue() + ey[i];
                if(tRow < 0 || tRow >= mRow || tCol <0 || tCol >= mCol) continue;
                if(grid[tRow][tCol] == 1 && used[tRow][tCol] == 0){
                    used[tRow][tCol] = 1;
                    queue.add(new Pair(tRow, tCol));
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Question_695 question = new Question_695();
        int[][] src = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(question.maxAreaOfIsland(src));
    }

}
