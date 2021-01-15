package com.steve.algorithms.repeat.dbfs;

import java.util.LinkedList;
import java.util.List;

public class DFSDemo {

  public static void main(String[] args) {
    DFSDemo dfsDemo = new DFSDemo();
    System.out.println(dfsDemo.permutationAll(new int[]{1,2,3}));
  }

  /**
   * 非重复数字全排列问题 1 2 3
   * 123 132
   */
  public List<List<Integer>> permutationAll(int[] src){
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tRes = new LinkedList<>();
    dfsPermutation(src, res, tRes);
    return res;
  }

  public void dfsPermutation(int[] src, List<List<Integer>> res, LinkedList<Integer> tRes){
    if(tRes.size() == src.length){
      res.add(new LinkedList<>(tRes));
      return ;
    }
    for(int i=0; i<src.length; i++){
      if(tRes.contains(src[i])) continue;
      tRes.add(src[i]);
      dfsPermutation(src, res, tRes);
      tRes.removeLast();
    }
  }

  /**
   * 重复数字全排列问题 1 2 2
   * 122
   * 212
   * 221
   */
  public List<List<Integer>> permutationAll2(int[] src){
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tRes = new LinkedList<>();
    dfsPermutation(src, res, tRes);
    return res;
  }

  public void dfsPermutation2(int[] src, List<List<Integer>> res, LinkedList<Integer> tRes){
    if(tRes.size() == src.length){
      res.add(new LinkedList<>(tRes));
      return;
    }
    for(int i=0; i< src.length; i++){
      if( i > 0 && src[i] == src[i-1]) continue;
    }
  }


}
