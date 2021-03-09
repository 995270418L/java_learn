package com.steve.algorithms.sword;

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Sword15 {

  public static void main(String[] args) {
    Sword15 sword14 = new Sword15();
    System.out.println(sword14.hammingWeight(8));
  }

  /**
   * 1 中有 1 个 1
   * 2 中有 1 个 1
   * 3 中有 2 个 1
   * 4 => 1
   *
   * 00000100
   * 00000110
   *
   * n % 2 == 0 ? 1
   * @param n
   * @return
   */
  public int hammingWeight(int n) {
    return Integer.bitCount(n);
  }

}
