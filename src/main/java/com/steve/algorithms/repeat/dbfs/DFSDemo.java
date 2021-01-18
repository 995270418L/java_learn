package com.steve.algorithms.repeat.dbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFSDemo {

  public static void main(String[] args) {
    DFSDemo dfsDemo = new DFSDemo();
    System.out.println(dfsDemo.permutationAll(new Integer[]{1,2,3}));
  }

  /**
   * 非重复数字全排列问题 1 2 3
   * 123 132
   */
  public List<List<Integer>> permutationAll(Integer[] src){
    List<List<Integer>> res = new LinkedList<>();
    dfsPermutation(src, 0, res);
    return res;
  }

  public void dfsPermutation(Integer[] src, int pos, List<List<Integer>> res){
    if(pos == src.length){
      res.add(Arrays.asList(src));
      return ;
    }
    for(int i=pos; i<src.length; i++){
      boolean cut = false;
//      for(int j=pos; j < i; j++){
//        if(src[j] == src[i]){
//          cut = true;
//          break;
//        }
//      }
      if(!cut){
        swap(src, pos, i);
        dfsPermutation(src, pos + 1, res);
        swap(src, pos, i);
      }
    }
  }

  /**
   * 重复数字全排列问题 2 1 2
   * 122
   * 212
   * 221
   */
  public List<List<Integer>> permutationAll2(int[] src){
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> tRes = new LinkedList<>();
    visited = new boolean[src.length];
    dfsPermutation2(src, res, tRes);
    return res;
  }

  private boolean[] visited;

  public void dfsPermutation2(int[] src, List<List<Integer>> res, LinkedList<Integer> tRes){
    if(tRes.size() == src.length){
      res.add(new LinkedList<>(tRes));
      return;
    }
    for(int i=0; i<src.length; i++){
      boolean flag = true;
      for(int j=tRes.size(); j < i; j++){
        if(src[j] == src[i]) flag = false;
      }
      int value = src[i];
      if(!visited[i] && flag){
        visited[i] = true;
        tRes.add(value);
        dfsPermutation2(src, res, tRes);
        tRes.removeLast();
        visited[i] = false;
      }
    }
  }

  public void dfsPermutation3(int[] src, int pos, List<List<Integer>> res, List<Integer> tRes){
    if(pos == src.length){
      res.add(new LinkedList<>(tRes));
      return;
    }
    for(int i=pos; i< src.length; i++){
      if(tRes.contains(src[i])) continue;
      tRes.add(src[i]);

    }
  }

  public void swap(Integer[] src, int a, int b){
    int temp = src[a];
    src[a] = src[b];
    src[b] = temp;
  }


}
