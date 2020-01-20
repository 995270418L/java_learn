package com.steve.algorithms.pass300;


/**
 *
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * 进阶:
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 */
public class Question_289 {

    /**
     * 遍历格子，得出奇偶性原则
     * 0 -> 2 1 -> 3
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = checkLogic(board, i, j);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }

    public int checkLogic(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int top = Math.max(0, i-1);
        int bottom = Math.min(i+1, m-1);
        int left = Math.max(j-1, 0);
        int right = Math.min(j+1, n-1);
        int count = 0;       // 统计活细胞的个数
        for(int l=top; l<=bottom; l++){
            for(int k=left; k<=right; k++){
                count = (board[l][k] == 1 || board[l][k] == -1) ? count + 1 : count;  // 值为1 或者 -1 表示这个位置的值当前是或者说以前是活细胞， 其它值都是死细胞
            }
        }
        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1 : -1 ) : count == 3 ? -2 : 0; // 活细胞变死细胞 1 -> -1,  死细胞转成活细胞 0 -> -2;
    }

    public static void main(String[] args) {
        Question_289 question = new Question_289();
        int[][] src = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        question.gameOfLife(src);
        System.out.println();
    }

}
