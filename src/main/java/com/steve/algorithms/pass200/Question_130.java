package com.steve.algorithms.pass200;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 *
 *
 */
public class Question_130 {

    // bfs 递归 从边界开始标记 树的前序遍历
    public void solve(char[][] board) {
        if(board == null || board.length <=0 ) return;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean isEdge = i == 0 || j == 0 || i == m-1 || j == n-1;
                if(isEdge && board[i][j] == 'O'){
                    dfsR(board, i, j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    public void dfsR(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i>=board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') return;
        board[i][j] = '#';
        dfsR(board, i-1, j); // 上
        dfsR(board, i, j+1); // 右
        dfsR(board, i+1, j);  // 下
        dfsR(board, i, j-1); // 左
    }

    /**
     *
     *
     * dfs 非递归的方式
     *
     *
     *
     */

    class Pos{
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //dfs  非递归， 使用栈，
    public void solve2(char[][] board) {
        if(board == null || board.length <=0 ) return;
        Stack<Character> stack = new Stack<>();
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean isEdge = i == 0 || j == 0 || i == m-1 || j == n-1;
                if(isEdge && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        board[i][j] = '#';
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(i, j));
        int m = board.length;
        int n = board[0].length;
        while (!stack.isEmpty()){
            Pos curr = stack.peek();
            // 上
            if(curr.x - 1 >= 0 && board[curr.x - 1][curr.y] == 'O'){
                stack.push(new Pos(curr.x - 1, curr.y));
                board[curr.x - 1][curr.y] = '#';
                continue;
            }
            // 下
            if(curr.x + 1 < m && board[curr.x + 1][curr.y] == 'O'){
                stack.push(new Pos(curr.x + 1, curr.y));
                board[curr.x + 1][curr.y] = '#';
                continue;
            }
            // 右
            if(curr.y + 1 < n && board[curr.x][curr.y + 1] == 'O'){
                stack.push(new Pos(curr.x, curr.y + 1));
                board[curr.x][curr.y + 1] = '#';
                continue;
            }
            // 左
            if(curr.y - 1 >= 0 && board[curr.x][curr.y - 1] == 'O'){
                stack.push(new Pos(curr.x, curr.y - 1));
                board[curr.x][curr.y - 1] = '#';
                continue;
            }
            stack.pop();
        }
    }

    /**
     *
     * bfs 宽度搜索 非递归方式
     *
     */
    public void solve3(char[][] board) {
        if(board == null || board.length <=0 ) return;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean isEdge = i == 0 || j == 0 || i == m-1 || j == n-1;
                if(isEdge && board[i][j] == 'O'){
                    bfs(board, i, j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    public void bfs(char[][] board, int i, int j){
        Queue<Pos> queue = new LinkedList<>();
        board[i][j] = '#';
        int m = board.length;
        int n = board[0].length;
        queue.add(new Pos(i, j));
        while (!queue.isEmpty()){
            Pos curr = queue.poll();
            if(curr.x - 1 >= 0 && board[curr.x - 1][curr.y] == 'O'){
                queue.add(new Pos(curr.x - 1, curr.y));
                board[curr.x - 1][curr.y] = '#';
            }
            if(curr.x + 1 < m && board[curr.x + 1][curr.y] == 'O'){
                queue.add(new Pos(curr.x + 1, curr.y));
                board[curr.x + 1][curr.y] = '#';
            }
            if(curr.y + 1 < n && board[curr.x][curr.y + 1] == 'O'){
                queue.add(new Pos(curr.x, curr.y + 1));
                board[curr.x][curr.y + 1] = '#';
            }
            if(curr.y - 1 >= 0 && board[curr.x][curr.y - 1] == 'O'){
                queue.add(new Pos(curr.x, curr.y - 1));
                board[curr.x][curr.y - 1] = '#';
            }
        }
    }


    public static void main(String[] args) {
        Question_130 question = new Question_130();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        question.solve3(src);
        System.out.println();
    }

}
