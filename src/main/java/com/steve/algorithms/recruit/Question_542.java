package com.steve.algorithms.recruit;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最长公共子串
 */
public class Question_542 {

    private int[][] change = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int res = 0;

    public static void main(String[] args) {
        Question_542 question = new Question_542();
        int[][] src = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        };
        question.updateMatrix(src);
        System.out.println();
    }

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return matrix;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = leave(matrix, i, j);
//                    res = 0;
//                    dfs(matrix, i, j);
//                    matrix[i][j] = res;
                }
            }
        }
        return matrix;
    }

    /**
     * bfs 实现查找
     *
     * @return
     */
    private int leave(int[][] matrix, int i, int j) {
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(i, j));
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair<Integer, Integer> pair = queue.poll();
                int tI = pair.getKey();
                int tY = pair.getValue();
                if (used[tI][tY]) continue;
                for (int l = 0; l < 4; l++) {
                    int tII = tI + change[l][0];
                    int tYY = tY + change[l][1];
                    if (isArea(tII, tYY, m, n) && !used[tI][tY]) {
                        if (matrix[tII][tYY] == 0) {
                            count++;
                            return count;
                        } else {
                            queue.add(new Pair(tII, tYY));
                        }
                    }
                }
                used[tI][tY] = true;
            }
            count++;
        }
        return count;
    }

    private boolean isArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public void dfs(int[][] matrix, int i, int j) {
        if (!isArea(i, j, matrix.length, matrix[0].length)) {
            return;
        }
        dfs(matrix, i - 1, j);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
        res++;
    }

}
