package com.steve.algorithms.repeat.matrixTraversal;

import com.steve.algorithms.base.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 * 算法详解：
 *    数据结构： 队列
 *    流程:
 */
public class BFSSample {

    /**
     * 130 被包围的区域
     * (1): 找寻边界上的 O, BFS 将它修改为 Y, 碰到 X 或者 Y 就不管
     * @param board
     */
    public void solve(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(i == 0 || i == board.length - 1 || j == 0 || j == board[i].length -1){
                    // 四大边界
                    if(board[i][j] == 'O') {
                        bfsSolve(board, i, j);
                    }
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfsSolve(char[][] board, int i, int j){
        int[] xP = {0, -1, 0, 1}; // 左 上 右 下
        int[] yP = {-1, 0, 1, 0};
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[board.length][board[0].length];
        queue.add(new Pair(i, j));
        while (!queue.isEmpty()){
            Pair<Integer, Integer> target = queue.poll();
            int x = target.getKey();
            int y = target.getValue();
            if(visited[x][y] == 1) continue;
            board[x][y] = 'Y';
            visited[x][y] = 1;
            for(int k=0; k< 4; k++){
                int tx = x + xP[k];
                int ty = y + yP[k];
                if( tx >= 0 && tx < board.length && ty >=0 && ty < board[0].length){
                    if(board[tx][ty] == 'O'){
                        queue.add(new Pair(tx, ty));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
//        char[][] src = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X' ,'X' ,'O','X'},
//                {'X' ,'O' ,'X' ,'X'}
//        };

        char[][] src = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O' ,'O' ,'O'},
        };
        BFSSample bfsSample = new BFSSample();
        bfsSample.solve(src);
        for(int i=0; i<src.length; i++){
            for(int j=0; j<src[i].length; j++){
                System.out.print(src[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
