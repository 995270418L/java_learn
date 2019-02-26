package com.steve.cow_guest.typical;

import java.util.Arrays;

/**
 * @Author: steve
 * @Date: Created in 15:12 2018/2/26
 * @Description: 原地交换排序，无额外空间。典例为荷兰国旗问题，给定一个包含0，1，2三种数字的数组，对其进行升序排序。
 * @Modified By:
 */
public class NoSpaceSort {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,0,1,1,2,1,0,1,2};
        array = noSpaceSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static int[] noSpaceSort(int[] array) {
        int l = -1,r = array.length,temp = 0;
        for(int k = 0; k< array.length; k++){
            if(array[k] == 0 && l < array.length){
                // 如果这个数为0，则和左侧区域的下一个数交换
                temp = array[k];
                array[k] = array[++l];
                array[l] = temp;
            }
            if(array[k] == 2 && r > 0){
                temp = array[k];
                array[k] = array[--r];
                array[r] = temp;
                // 交换完毕之后不进行
                k--;
            }
            // 当 r 的大小和 k+1 大小相等的时候说明后面的数据已经遍历过了，就可以退出遍历了
            if(r == k+1){
                break;
            }
        }
        return array;
    }
}
