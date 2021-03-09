package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;


/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 */
public class Sword29 {

  public static void main(String[] args) {
    Sword29 sword14 = new Sword29();
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(5);
    TreeNode ll = new TreeNode(2);
    TreeNode lr = new TreeNode(1);
    root.left = left;
    root.right = right;
    left.left = ll;
    System.out.println(sword14.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
  }

  /**
   * 顺时针打印矩阵
   * @param matrix
   * @return
   */
  public int[] spiralOrder(int[][] matrix) {
    int r = matrix.length;
    if(r <= 0) return new int[]{};
    int c = matrix[0].length;
    int[] res = new int[r * c];
    int left=0, top = 0;
    int right = c - 1, down = r - 1;
    int idx = 0;
    while (true){
      // 右
      for(int i=left; i<=right; i++){
        res[idx++] = matrix[top][i];
      }
      if(idx > res.length-1) break;
      top ++;
      // 下
      for(int i=top; i<=down; i++){
        res[idx++] = matrix[i][right];
      }
      if(idx > res.length-1) break;
      right --;
      // 左
      for(int i=right; i>=left; i--){
        res[idx++] = matrix[down][i];
      }
      if(idx > res.length-1) break;
      down --;
      // 上
      for(int i=down; i>=top; i--){
        res[idx++] = matrix[i][left];
      }
      if(idx > res.length-1) break;
      left ++;
    }
    return res;
  }

}
