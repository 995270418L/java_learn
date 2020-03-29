package com.steve.algorithms.recruit;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 */
public class Question_1162 {

    // 左、上、右、下
    int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        Question_1162 question = new Question_1162();
        String[] strs = {"flight", "flow", "flower"};
        int[][] grid = {
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}
        };
        System.out.println(question.maxDistance(grid));
    }

    /**
     * 暴力法找最近的 陆地
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int bfs(int[][] grid, int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] used = new int[grid.length][grid.length];
        queue.add(new Pair(i, j));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            int tI = poll.getKey();
            int tJ = poll.getValue();
            if (used[tI][tJ] == 1) continue;
            used[tI][tJ] = 1;
            if (grid[tI][tJ] == 1) {
                return Math.abs(tI - i) + Math.abs(tJ - j);
            }
            for (int k = 0; k < 4; k++) {
                int tII = tI + dir[k][0];
                int tJJ = tJ + dir[k][1];
                if (isArea(grid, tII, tJJ)) {
                    queue.add(new Pair(tII, tJJ));
                }
            }
        }
        return -1;
    }

    public Boolean isArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

}
