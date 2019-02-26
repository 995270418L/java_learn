package com.steve.cow_guest.typical.binarySearch;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: steve
 * @Date: Created in 15:44 2018/2/28
 * @Description: 从有序数列中找寻某个数的最左位置 例如 11222333334444444 这一数列，找寻3的最左位置
 * 解决：
 *     用res记录查找的坐标，初始时为-1.
 * @Modified By:
 */
public class RepeatLeftNum {

    private static final int FIND = 3;
    
    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,4,4,4,4,4,4,4,4,4};
        List<Integer> list = new LinkedList<>();
        findLeft(array,0,array.length - 1, list);
        int min = 9999999;
        if(list == null){
            min = -1;
        }
        for(Integer result : list){
            if(result < 0){
                continue;
            }else if(result < min){
                min = result;
            }
        }
        System.out.println("数字"+ FIND + "在数列里的最左位置为: " + min);
    }

    private static void findLeft(int[] array,int left,int right, List<Integer> result) {
        int res = -1;
        if(right < left){
            return ;
        }
        int mid = left + (right-left) / 2;
        if(array[mid] < FIND){
            findLeft(array,mid+1,right,result);
        }else if(array[mid] > FIND){
            findLeft(array,left,mid-1,result);
        }else if(array[mid] == FIND){
            findLeft(array,left,mid-1,result);
            result.add(mid);
        }
    }

}
