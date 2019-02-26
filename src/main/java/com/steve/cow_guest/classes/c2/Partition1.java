package com.steve.cow_guest.classes.c2;

/**
 * @Author: steve
 * @Date: Created in 18:34 2018/6/14
 * @Description: 给定一个数字数组和一个指定的数，假定这数组里面的数都不和这个数相等。要求将数组中的数小于指定数的放在数组左边，
 *              大于的放右边，时间复杂度O(N),空间复杂度O(1)
 * @Modified By:
 */
public class Partition1 {

    /**
     * 两个变量控制，一个是控制小于区域less,一个是当前遍历的指针cur。当遇到的当前数比指定数小，就和less的下一个数交换，less++,cur++,
     *  当遇到的数比指定数大，cur++
     * @param arr
     * @param n
     */
    public void exchange(int[] arr,int n){
        int len = arr.length;
        int less = -1,tmp;
        for(int i=0;i<len;i++){
            if(arr[i] < n){
                tmp = arr[i];
                arr[i] = arr[++less];
                arr[less] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,4,2,8,1,7};
        new Partition1().exchange(arr,5);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
