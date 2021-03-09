package com.steve.algorithms.sword;


public class Sword17 {

  public static void main(String[] args) {
    Sword17 sword14 = new Sword17();
    System.out.println(sword14.printNumbers(2));
  }

    public int[] printNumbers(int n) {
      if(n <= 0) return null;
      int max = (int) (Math.pow(10,n) - 1);
      int[] res = new int[max];
      for(int i=0; i< res.length; i++){
          res[i] = i+1;
      }
      return res;
    }

}
