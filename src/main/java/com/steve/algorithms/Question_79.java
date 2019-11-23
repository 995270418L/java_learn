package com.steve.algorithms;

/**
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 *
 */
public class Question_79 {

    private char[][] board;
    private int[][] marked;
    private int[][] direction = {{-1, 0},{0, 1},{1, 0},{0, -1}}; // 上 右 下 左
    private String word;
    private int r;
    private int c;

    public boolean exist(char[][] board, String word) {
        this.r = board.length;
        if(this.r == 0){
            return false;
        }
        this.c = board[0].length;
        this.word = word;
        this.board = board;
        this.marked = new int[r][c];
        for(int i=0; i< r; i++){
            for(int j =0; j< c; j++){
                if(dfs(i, j, 0)){
                    // DFS 判断
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int start) {
        if(start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if(word.charAt(start) == board[i][j]){
            marked[i][j] = 1;
            // 四个方向判断
            for(int d=0; d< 4; d++){
                int newX = i + direction[d][0];
                int newY = j + direction[d][1];
                if(isArea(newX, newY) && marked[newX][newY] == 0){
                    if(dfs(newX, newY, start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = 0;  // 实现回溯算法关键
        }
        return false;
    }

    public boolean isArea(int x, int y){
        return x >= 0 && x < r && y >=0 && y < c;
    }

    public static void main(String[] args) {
        Question_79 question = new Question_79();
        System.out.println(question.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }

}
