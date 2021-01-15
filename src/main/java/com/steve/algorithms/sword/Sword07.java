package com.steve.algorithms.sword;

import com.steve.algorithms.base.ListNode;
import com.steve.algorithms.base.TreeNode;

/**
 * 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 */
public class Sword07 {


  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length <= 0){
      return null;
    }
    return recursive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
  }

  private TreeNode recursive(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd){
    if(pStart > pEnd || iStart > iEnd ){
      return null;
    }
    TreeNode root = new TreeNode(preOrder[pStart]);
    for(int i=iStart; i<=iEnd; i++){
      if(inOrder[i] == preOrder[pStart]){
        root.left = recursive(preOrder, pStart +1, pStart + i - iStart, inOrder, iStart,i - 1);
        root.right = recursive(preOrder, pStart + i + 1 - iStart, pEnd, inOrder,i + 1, iEnd);
      }
    }
    return root;
  }

  /**
   * pre: 1,2,4,7,3,5,6,8
   * in: 4,7,2,1,5,3,8,6
   *
   * ===>
   *
   * in ===> left: 4,7,2 right: 5,3,8,6
   * pre ===> left: 2,4,7 right: 3,5,6,8
   *
   *
   * @param args
   */
  public static void main(String[] args) {
    Sword07 sword05 = new Sword07();
    System.out.println(sword05.buildTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6}));
  }

}
