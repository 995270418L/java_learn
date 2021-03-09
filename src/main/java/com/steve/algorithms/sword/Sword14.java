package com.steve.algorithms.sword;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 *
 */
public class Sword14 {

  public static void main(String[] args) {
    Sword14 sword14 = new Sword14();
    System.out.println(sword14.cuttingRope(8));
  }
  /**
   * 状态定义：
   *  dp[i] 表示 长度为 i 时得到的最大乘积
   *
   * 状态转移方程：
   *  先剪前 j 段， 剩下的 i-j 段有两种策略。
   *  1. 不剪，则乘积为 j * (i - j)
   *  2. 剪， 则乘积为 j * dp [i - j]
   *  正常情况 dp[i] = max(j * (i-j), j * dp[i-j])
   *  但由于 j 的值为 1 - i 的一个范围range， 所以需要和 dp[i] 的值比较大小。
   *
   *  最终得出的转移方程：
   *  dp[i] = max(dp[i], max(j * (i-j), j * dp[i-j]))
   *
   * 初始状态：
   *  dp[1] = 1
   *  dp[2] = 1
   *
   * 状态压缩：
   *
   * @param n
   * @return
   */
  public int cuttingRope(int n) {
    if(n <= 2) return 1;
    int[] dp = new int[n + 1];
    dp[2] = 1;
    for(int i=3; i<=n; i++){
      for(int j=2; j<i; j++){
        dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
      }
    }
    return dp[n];
  }


}
