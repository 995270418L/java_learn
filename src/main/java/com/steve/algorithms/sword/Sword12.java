package com.steve.algorithms.sword;

import java.util.LinkedList;

/**
 * 矩阵中的路径问题
 *
 */
public class Sword12 {

  private boolean result = false;
  private int[][] dire = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

  /**
   * BFS 广度优先遍历
   * @param board
   * @param word
   * @return
   */
  public boolean exist(char[][] board, String word) {
    if(board == null || word == null){
      return false;
    }
    char[] words = word.toCharArray();
    for(int i=0; i<board.length; i++){
      for(int j=0; j< board[i].length; j++){
        char t = board[i][j];
        if(t == words[0]) {
          LinkedList<Character> res = new LinkedList<>();
          res.add(t);
          board[i][j] = ',';
          if (dfs(board, words, i, j, res)) return true;
          board[i][j] = t;
        }
      }
    }
    return false;
  }

  /**
   * 这道题目还是用 dfs 来解决比较方便，如果路径不对直接回溯到原来的位置。
   *
   * @return
   */
  public boolean dfs(char[][] board, char[] word, int m, int n, LinkedList<Character> list){
    if(list.size() == word.length){
      return true;
    }
    boolean res = false;
    for(int i=0; i< dire.length; i++) {
      int tI = m + dire[i][0];
      int tJ = n + dire[i][1];
      if (tI >= 0 && tI < board.length && tJ >= 0 && tJ < board[0].length) {
        char t = board[tI][tJ];
        if(t == word[list.size()]) {
          list.add(t);
          board[tI][tJ] = ',';
          res = dfs(board, word, tI, tJ, list);
          if(res) return true;
          list.removeLast();
          board[tI][tJ] = t;
        }
      }
    }
    return res;
  }

  public boolean dfs2(char[][] board, char[] word, int i, int j, int k){
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word[k] != board[i][j]) return false;
    if(k == word.length - 1) return true;
    board[i][j] = ',';
    boolean res = dfs2(board, word, i+1, j, k+1) || dfs2(board, word, i - 1, j, k+1) || dfs2(board, word, i, j + 1, k + 1) || dfs2(board, word, i, j-1, k+1);
    board[i][j] = word[k];
    return res;
  }

  public static void main(String[] args) {
    Sword12 sword05 = new Sword12();
    System.out.println(sword05.exist(new char[][]{{'A','A'}}, "AAA"));
//    System.out.println(sword05.exist(new char[][]{{'C','A','A'},
//                                                  {'A','A','A'},
//                                                  {'B','C','D'}},"AAB"));

//    System.out.println(sword05.exist(new char[][]{
//            {'A','B','C','E'},
//            {'S','F','C','S'},
//            {'A','D','E','E'},
//            },"ABCCED"));
  }

}
