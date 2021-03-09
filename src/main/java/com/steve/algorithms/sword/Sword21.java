package com.steve.algorithms.sword;


/**
 *
 */
public class Sword21 {

  public static void main(String[] args) {
    Sword21 sword14 = new Sword21();
    System.out.println(sword14.exchange(new int[]{1,2,3,4}));
  }

  public int[] exchange(int[] nums) {
    int i=0,j=nums.length - 1;
    while (i <= j) {
      if(nums[i] % 2 == 0){
        // 偶数和 j 交换
        swap(nums, i, j--);
      }else{
        i++;
      }
    }
    return nums;
  }

  public void swap(int[] src, int i, int j){
    int t = src[i];
    src[i] = src[j];
    src[j] = t;
  }

}
