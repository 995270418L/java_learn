package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;


public class Sword47 {

  public static void main(String[] args) {
    Sword47 sword14 = new Sword47();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    int[] arr = new int[]{3,30,34,5,9};
    int[][] src = new int[][]{
                                {1,2,5},
                                {3,2,1}
                              };
    System.out.println(sword14.maxValue(src));
  }

  public int maxValue(int[][] grid) {
//    return dfs(grid,0,0);
    return dp(grid);
  }

  /**
   * 普通的dfs超出时间限制   ！！！
   * @param grid
   * @param m
   * @param n
   * @return
   */
  public int dfs(int[][] grid, int m, int n){
    if(m >= grid.length || n >= grid[0].length) return 0;
    if(grid.length-1 == m && grid[0].length - 1 == n) return grid[m][n];
    return Math.max(dfs(grid, m+1, n), dfs(grid,m, n+1)) + grid[m][n];
  }

  /**
   * 动态规划试试
   * dp[i][j] 表示第i行j列的礼物最大值。
   *
   * dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
   *
   * @return
   */
  public int dp(int[][] grid){
    int m = grid.length, n = grid[0].length;
    int[][] memo = new int[m][n];
    memo[0][0] = grid[0][0];
    for(int i=1; i<m; i++){
      memo[i][0] = memo[i-1][0] + grid[i][0];
    }
    for(int j=1; j<n; j++){
      memo[0][j] = memo[0][j-1] + grid[0][j];
    }
    for(int i=1; i< grid.length; i++){
      for(int j=1; j<grid[i].length; j++){
        memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]) + grid[i][j];
      }
    }
    return memo[m-1][n -1];
  }

}
