package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 */
public class Sword28 {

  public static void main(String[] args) {
    Sword28 sword14 = new Sword28();
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(5);
    TreeNode ll = new TreeNode(2);
    TreeNode lr = new TreeNode(1);
    root.left = left;
    root.right = right;
    left.left = ll;
//    System.out.println(sword14.printTree(root));
  }

  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return dfs(root.left, root.right);
  }

  /**
   * 判断两颗子树是否一致。
   * @param left
   * @param right
   * @return
   */
  public boolean dfs(TreeNode left, TreeNode right){
      if(left == null && right == null) return true;
      if(left == null || right == null) return false;
      return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
  }

}
