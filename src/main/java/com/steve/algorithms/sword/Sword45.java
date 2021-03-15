package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;


public class Sword45 {

  public static void main(String[] args) {
    Sword45 sword14 = new Sword45();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    int[] arr = new int[]{3,30,34,5,9};
    System.out.println(sword14.minNumber(arr));
  }

  /**
   * 先试试冒泡排序
   * @param nums
   * @return
   */
  public String minNumber(int[] nums) {
    quickSort(nums,0, nums.length - 1);
    String res = "";
    for(int i=0; i< nums.length; i++){
      res += nums[i];
    }
    return res;
  }

  public void quickSort(int[] arr, int left, int right){
    if(left < right){
      int p = partition(arr, left, right);
      quickSort(arr, left, p - 1);
      quickSort(arr, p + 1, right);
    }
  }

  public int partition(int[] arr, int left, int right){
    int x = arr[right];
    int j = left - 1;
    for(int i=left; i< right; i++){
      if(lessThan(arr[i], x)){
        swap(arr, i, ++j);
      }
    }
    swap(arr, ++j, right);
    return j;
  }

  /**
   * compare a is less than b
   * eg: 303 -> 3  101 -> 3 2 -> 21113 20 -> 201
   * @param a
   * @param b
   * @return
   */
  public boolean lessThan(int a, int b){
    String as = a + "";
    String bs = b + "";
    return (as + bs).compareTo(bs + as) < 0;
  }

  public void swap(int[] arr, int i, int j){
    if(i != j){
      int t = arr[i];
      arr[i] = arr[j];
      arr[j] = t;
    }
  }

}
