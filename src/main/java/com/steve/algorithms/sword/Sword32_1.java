package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.*;


/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 */
public class Sword32_1 {

  public static void main(String[] args) {
    Sword32_1 sword14 = new Sword32_1();
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(5);
    TreeNode ll = new TreeNode(2);
    TreeNode lr = new TreeNode(1);
    root.left = left;
    root.right = right;
    left.left = ll;
    System.out.println(sword14.levelOrder(null));
  }

  /**
   * 层次遍历树
   *
   * BFS 没有递归的实现方式
   *
   * @param root
   * @return
   */
  public int[] levelOrder(TreeNode root) {
    if(root == null) return new int[]{};
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()){
      TreeNode parent = queue.poll();
      res.add(parent.val);
      if(parent.left != null){
        queue.add(parent.left);
      }
      if(parent.right != null){
        queue.add(parent.right);
      }
    }
    int[] target = new int[res.size()];
    for(int i=0; i<res.size(); i++){
      target[i] = res.get(i);
    }
    return target;
  }

}
