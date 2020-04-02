package com.steve.algorithms.recruit;

/**
 * 生命游戏
 */
public class Question_289 {

    public static void main(String[] args) {
        Question_289 question = new Question_289();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        question.gameOfLife(board);
        System.out.println();
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                change(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = board[i][j];
                if (tmp > 1) {
                    board[i][j] = tmp % 2 == 0 ? 1 : 0;
                }
            }
        }
    }

    private void change(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int aliveCount = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < m && l >= 0 && l < n && (k != i || l != j)) {
                    if (board[k][l] % 2 != 0) {
                        aliveCount++;
                    }
                }
            }
        }
        // 死细胞
        if (board[i][j] == 0 && aliveCount == 3) {
            board[i][j] = 2;  // + 2
        } else if (board[i][j] == 1 && (aliveCount < 2 || aliveCount > 3)) {
            board[i][j] = 3;  // + 2
        }
    }

}
