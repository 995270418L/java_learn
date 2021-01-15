package com.steve.algorithms.company;

public class a {

  public static void main(String[] args) {
    int[] task = new int[]{5,7,2,1,4,2};
    int len = task.length;
    for(int i=0; i < len; i++){
      for(int j=i+1; j< len; j++){
        if(task[i] > task[j]){
          swap(task, i, j);
        }
      }
    }
    println(task);
  }

  public static void swap(int[] src, int i, int j){
    int a = src[i];
    src[i] = src[j];
    src[j] = a;
  }

  public static void println(int[] src){
    for(int i : src){
      System.out.println(i);
    }
  }

}
