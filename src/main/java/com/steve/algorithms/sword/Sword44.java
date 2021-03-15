package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;


public class Sword44 {

  public static void main(String[] args) {
    Sword44 sword14 = new Sword44();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(sword14.findNthDigit(10));
  }

  public int findNthDigit(int n) {
    return 0;
  }

}
