package com.steve.cow_guest.classes.c3;

/**
 * @Author: steve
 * @Date: Created in 20:19 2018/6/16
 * @Description: 给定一个有限长数组，只能花费O(n)的时间进行排序，求排序后相邻两数的最大差值。不能使用非基于比较的排序。
 * 这里用桶排序的思想，但不进行桶排序。数组长度为N，建立桶的大小为 N+1，首先遍历一遍数组，找出最大最小值，放在第一个桶和最后一个桶。
 * 遍历数组，给每个数找一个桶位置
 * 每个桶有三种技术指标，一个bool值，表示是否为空，一个min值，表示这个桶里面的数的最小值，一个max，表示这个桶里面的最大值max。
 * 遍历桶，取个全局变量max，当桶为非空桶时，求其于最左边非空桶的最大最小值差值。最后返回max。
 * @Modified By:
 */
public class MaxGap {

    public static int maxGap(int[] arr){
        int len = arr.length + 1;  // 桶的个数
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 第一次遍历找最大最小值
        for(int i=0;i < len-1;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        boolean[] hasNum = new boolean[len];
        int[] minN = new int[len];
        int[] maxN = new int[len];
        int location;   // 每个数对应桶的下标
        // 第二次遍历，给每个数找一个对应桶的位置并比较得出该桶最大最小值
        for(int i=0; i< len-1;i++){
            location = bucket(arr[i],len-1,min,max);
            minN[location] = hasNum[location] ? Math.min(arr[i],minN[location]) : arr[i];
            maxN[location] = hasNum[location] ? Math.max(arr[i],maxN[location]) : arr[i];
            hasNum[location] = true;
        }
        int maxP = Integer.MIN_VALUE;
        int fMax = maxN[0]; // 前一个非空桶的最大值。
        // 第三次遍历桶
        for(int i = 1; i< len;i++){
            if(hasNum[i]){
                maxP = Math.max(maxP,minN[i] - fMax);
                fMax = maxN[i];
            }
        }
        return maxP;
    }
    /**
     *
     * @param num 数组的数字
     * @param len 数组的长度
     * @param min 数组的最小值
     * @param max 数组的最大值
     * @return
     */
    private static int bucket(int num, int len, int min, int max) {
        return (num - min)*len/(max - min);
    }

    public static void main(String[] args) {
        System.out.println(maxGap(new int[]{1,3,8,7,9}));
    }
}
