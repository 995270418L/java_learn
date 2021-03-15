package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 */
public class Sword32_2 {

  public static void main(String[] args) {
    Sword32_2 sword14 = new Sword32_2();
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
   * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // 非递归实现
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()){
      int size = queue.size();
      List<Integer> t = new ArrayList<>();
      while (size-- > 0){
        TreeNode tmp = queue.poll();
        t.add(tmp.val);
        if(tmp.left != null) queue.add(tmp.left);
        if(tmp.right != null) queue.add(tmp.right);
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
    res.get(k).add(node.val);
    if(node.left != null) recursion(res, node.left, k+1);
    if(node.right != null) recursion(res, node.right, k+1);
  }

}
