package com.steve.algorithms.sword;


import com.steve.algorithms.base.ListNode;
import com.steve.algorithms.base.TreeNode;


/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 */
public class Sword26 {

  public static void main(String[] args) {
    Sword26 sword14 = new Sword26();
    TreeNode t1 = new TreeNode(3);
    TreeNode t11 = new TreeNode(4);
    TreeNode t12 = new TreeNode(5);
    TreeNode t21 = new TreeNode(1);
    TreeNode t22 = new TreeNode(2);


    System.out.println(sword14.isSubStructure(null, null));
  }

  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if(A == null || B == null){
      return false;
    }
    return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }

  public boolean dfs(TreeNode A, TreeNode B){
    if(A == null) return false;
    if(B == null) return true;
    return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
  }

}
