package com.steve.algorithms.sword;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Sword40 {

  public static void main(String[] args) {
    Sword40 sword14 = new Sword40();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode ll = new TreeNode(4);
    TreeNode lr = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = ll;
    right.right = lr;
    int[] arr = new int[]{0,0,0,1,2,2,3,7,6,1};
//    sword14.getLeastNumbers(arr, 3);
    sword14.quickSort(arr, 0, arr.length-1);
    System.out.println("null");
  }

  public int[] getLeastNumbers(int[] arr, int k) {
    if(k <= 0) return new int[k];
    return search(arr,0, arr.length - 1, k-1);
  }

  public int[] search(int[] arr, int left, int right, int k){
    int l = partition(arr, left, right);
    if(l == k){
      return Arrays.copyOf(arr,l+1);
    }
    return l > k ? search(arr, left, l, k) : search(arr, l+1, right, k);
  }

  public int partition(int[] arr, int left, int right){
    int x = arr[left];
    int j = left;
    for(int i=left + 1; i<=right; i++){
      if(arr[i] <= x){
        swap(arr,i,++j);
      }
    }
    swap(arr, j, left);
    return j;
  }

  public void quickSort(int[] arr, int left, int right){
    if(left < right){
      int p = partition(arr, left, right);
      quickSort(arr, left, p-1);
      quickSort(arr, p +1, right);
    }
  }


  public void swap(int[] arr, int i, int j){
    if(i != j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
  }

}
