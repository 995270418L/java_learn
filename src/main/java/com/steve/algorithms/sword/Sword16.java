package com.steve.algorithms.sword;


public class Sword16 {

  public static void main(String[] args) {
    Sword16 sword14 = new Sword16();
    System.out.println(sword14.myPow2(2,-2));
  }

  /**
   * 二分法
   *    x ^ n == x ^ (2 * n/2)
   *
   * @param x
   * @param n
   * @return
   */
   public double myPow(double x, int n) {
    if(x == 0) return 0;
    long ln = n;
    if(n < 0){
      ln = -n;
      x = 1/x;
    }
    double res = 1;
    while (ln != 0){
      if((ln & 1) == 1) {
          res *= x;
      }
      x *= x;
      ln >>= 1;
    }
    return res;
   }

    public double myPow2(double x, int n) {
       if(n == 0 || x == 1) return 1;
       if(n == 1) return x;
       long ln = n;
       if(ln < 0){
           ln = -ln;
           x = 1/x;
       }
       double half = myPow2(x, (int) (ln/2));
       return ln % 2 == 0 ?  half * half : half*half*x;
    }
}
