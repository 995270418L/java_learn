package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;


public class Sword48 {

  public static void main(String[] args) {
    Sword48 sword14 = new Sword48();
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
    System.out.println(sword14.lengthOfLongestSubstring("abcabcbb"));
  }

  public int lengthOfLongestSubstring(String s) {
    return 0;
  }

}
