package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.*;


public class Sword38 {

  public static void main(String[] args) {
    Sword38 sword14 = new Sword38();
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
    System.out.println(sword14.permutation("suvyls"));
  }

  /**
   * 回溯法
   */
  public String[] permutation(String s) {
    String [] kk = s.split("");
    Arrays.sort(kk);
    StringBuilder sb = new StringBuilder();
    for(String x:kk) sb.append(x);
    s = sb.toString();

    sb.delete(0,sb.length());
    List<String> res = new ArrayList<>();
    help(res, new StringBuilder(), new boolean[s.length()], s);
    return res.toArray(new String[res.size()]);
  }


  /**
   * 没重复字符串处理方式
   * @param res
   * @param list
   * @param s
   */
  public void help(List<List<Character>> res, LinkedList<Character> list, String s){
    if(list.size() == s.length()){
      res.add(new LinkedList<>(list));
      return;
    }
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(!list.contains(c)){
        list.add(c);
        help(res, list, s);
        list.removeLast();
      }
    }
  }

  public void help(List<String> res, StringBuilder sb, boolean[] used, String s){
    if(sb.length() == s.length()){
      res.add(sb.toString());
      return;
    }
    for(int i=0; i<s.length(); i++){
      if(!used[i]){
        if( i > 0 && s.charAt(i) == s.charAt(i-1) && !used[i-1]) continue;
        char c = s.charAt(i);
        sb.append(c);
        used[i] = true;
        help(res, sb, used, s);
        sb.deleteCharAt(sb.length() - 1);
        used[i] = false;
      }
    }
  }

}
