package com.steve.cow_guest.typical.sort;

import java.util.Arrays;

/**
 * @Author: steve
 * @Date: Created in 10:42 2018/3/6
 * @Description: 手写快排
 * @Modified By:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] source = {1,0};
        quickSortPartition(source,0,source.length - 1);
        Arrays.stream(source).forEach(System.out::print);
    }


    /**
     * 递归每一次划分过程
     * @param source
     * @param start
     * @param end
     * @return
     */
    private static void quickSortPartition(int[] source, int start, int end) {
        if(start >= end){
            return;
        }
        int changeV = source[start],j = start-1;   //j相当于一个小于等于区间的右边界
        change(source,start,end);
        for(int i = start; i < end; i ++){
            // 如果当前值小于等于选定的值，就让当前值和小于等于区间的下一个数交换，同时小于等于区间发生 ++操作
            if(source[i] <= changeV){
                change(source,i,++j);
            }
        }
        // 交换之间的一个值
        change(source,end,++j);
        quickSortPartition(source, start, j - 1);
        quickSortPartition(source,j+1,end);
    }

    private static void change(int[] source, int start, int end){
        int temp = source[start];
        source[start] = source[end];
        source[end] = temp;
    }
}
