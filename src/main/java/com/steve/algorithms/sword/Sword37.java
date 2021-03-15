package com.steve.algorithms.sword;


import com.steve.algorithms.base.Node;
import com.steve.algorithms.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Sword37 {

  public static void main(String[] args) {
    Sword37 sword14 = new Sword37();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
//    System.out.println(sword14.serialize(root));
    System.out.println(sword14.deserialize("1,2,4,null,null,null,3,null,5,null,null,"));
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null){
      return "null,";
    }
    String res = root.val + ",";
    res += serialize(root.left);
    res += serialize(root.right);
    return res;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == null || data.trim().equals("")) return null;
    String[] split = data.split(",");
    Queue<String> queue = new LinkedList<>();
    for(int i=0; i<split.length; i++){
      queue.offer(split[i]);
    }
    return helper(queue);
  }

  public TreeNode helper(Queue<String> queue){
    String poll = queue.poll();
    if(poll == null || poll.equals("null")){
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(poll));
    node.left = helper(queue);
    node.right = helper(queue);
    return node;
  }

}
