package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;
import lombok.val;


/**
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 */
public class Sword27 {

  public static void main(String[] args) {
    Sword27 sword14 = new Sword27();
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(5);
    TreeNode ll = new TreeNode(2);
    TreeNode lr = new TreeNode(1);
    root.left = left;
    root.right = right;
    left.left = ll;
    System.out.println(sword14.mirrorTree(root));
  }

  public TreeNode mirrorTree(TreeNode root) {
    if(root == null) return null;
    swap(root, root.left, root.right);
    mirrorTree(root.left);
    mirrorTree(root.right);
    return root;
  }

  public void swap(TreeNode root, TreeNode left, TreeNode right){
    TreeNode tmp = left;
    root.left = right;
    root.right = tmp;
  }

}
