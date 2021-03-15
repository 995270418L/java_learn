package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.*;


/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 */
public class Sword32_3 {

  public static void main(String[] args) {
    Sword32_3 sword14 = new Sword32_3();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    System.out.println(sword14.levelOrderRecursion(root));
  }

  /**
   * 层次遍历树
   * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
   * 第三行再按照从左到右的顺序打印，其他行以此类推。
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    queue.add(root);
    stack.push(root);
    while (!queue.isEmpty()){
      List<Integer> t = new ArrayList<>();
      int size = queue.size();
      while (size -- > 0){
        queue.poll();
        TreeNode node = stack.pop();
        t.add(node.val);
        if (node.left != null){
          queue.add(node.left);
          stack.push(node.left);
        }
        if (node.right != null){
          queue.add(node.right);
          stack.push(node.right);
        }

      }
      res.add(t);
    }
    return res;
  }

  /**
   * 递归实现
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrderRecursion(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    recursion(res,root,0);
    return res;
  }

    /**
   *
   * @param res 最终结果
   * @param node 当前遍历的节点
   * @param k 第 K 层
   */
  public void recursion(List<List<Integer>> res, TreeNode node, int k){
    if(node == null) return;
    if(res.size() <= k) res.add(new ArrayList<>());
    if(k % 2 != 0){
      res.get(k).add(0, node.val);
    }else{
      res.get(k).add(node.val);
    }
    if (node.left != null) recursion(res, node.left, k + 1);
    if (node.right != null) recursion(res, node.right, k + 1);
  }

}
