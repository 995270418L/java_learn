package com.steve.algorithms.sword;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 青蛙跳台阶问题
 *
 */
public class Sword10 {

  private Map<Integer, Integer> memo = new HashMap<>();

  public int numWays(int n) {
    if(n == 0){
      return 1;
    }else if(n < 0){
      return 0;
    }
    int left = 0;
    if(memo.get(n-1) != null){
      left = memo.get(n-1);
    }else{
      left = numWays(n-1);
      memo.put(n-1, left);
    }
    int right = 0;
    if(memo.get(n-2) != null){
      right = memo.get(n-2);
    }else{
      right = numWays(n-2);
      memo.put(n-2, left);
    }
    return (left + right) % (1000000007);
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
    Sword10 sword05 = new Sword10();
    System.out.println(sword05.numWays(41));
  }

}
