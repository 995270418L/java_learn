package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.*;


public class Sword33 {

  public static void main(String[] args) {
    Sword33 sword14 = new Sword33();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    System.out.println(sword14.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
  }

  /**
   * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
   * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
   *
   * 主要逻辑就是找到第一个大于根节点的值。
   * @param postorder
   * @return
   */
  public boolean verifyPostorder(int[] postorder) {
    if(postorder == null) return false;
    return verify(postorder,0, postorder.length - 1);
  }

  public boolean verify(int[] order, int left, int right){
    if(left > right) return true;
    int rootValue = order[right];
    int k = left;
    while (k < right && order[k] < rootValue) k++;
    for(int i=k+1; i<right; i++) {
      if (order[i] < rootValue) return false;
    }
    if(!verify(order,left, k-1)) return false;
    if(!verify(order, k, right-1)) return false;
    return true;
  }

}
