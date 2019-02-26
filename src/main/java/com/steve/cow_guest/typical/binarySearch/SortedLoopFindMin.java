package com.steve.cow_guest.typical.binarySearch;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: steve
 * @Date: Created in 16:33 2018/2/28
 * @Description: 有序循环数组找最小值。
 * 解决:
 *      如果arr[0] < arr[N-1]; 最小值为arr[0]
 *
 * @Modified By:
 */
public class SortedLoopFindMin {

    public static void main(String[] args) {
        Permutation("acc");
    }

    public static void Permutation(String str) {
        char[] strs = str.toCharArray();
        permutation(strs,0,strs.length - 1);
    }

    static void permutation(char[] chars, int begin,int end){
        if(end <= 1){
            return ;
        }
        if(begin == end){
            System.out.print(new String(chars) + "\t");
        }else{
            for(int i=begin;i<=end;i++){
                swap(chars,i,begin);
                permutation(chars,begin+1,end);
                swap(chars,begin,i);
            }
        }
    }

    private static void swap(char[] chars, int begin, int end) {
        char temp = chars[begin];
        chars[begin] = chars[end];
        chars[end] = temp;
    }
}
