package com.steve.cow_guest.typical;

import java.util.Arrays;

/**
 * @Author: steve
 * @Date: Created in 13:43 2018/2/26
 * @Description: 合并两个有序数组为一个有序数组，要求空间复杂度为 O(1)
 * @Modified By:
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{4,5,6};
        int[] array2 = new int[]{1,2,3};
        int[] newArray = mergeArray(array1,array2);
        Arrays.stream(newArray).forEach(System.out::println);
    }

    private static int[] mergeArray(int[] array1, int[] array2) {
        int a = array1.length;
        int b = array2.length;
        int[] newArray = Arrays.copyOf(array2,a+b);
        for(int i = a - 1; i>=0 ; i--){
            int j = 0;
            for(j = b - 1; j>=0 ; j--){
                if(array2[j] >= array1[i]){
                    newArray[i+j+1] = array2[j];
                    b -- ;
                }else{
                    newArray[i+j+1] = array1[i];
                    break;
                }
                if(j == 0){
                    b = 0;
                }
            }
            if(i >= 0 && j <0){
                newArray[i+j+1] = array1[i];
            }
        }
        return newArray;
    }
}
