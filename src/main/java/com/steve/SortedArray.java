package com.steve;

import java.util.*;

/**
 * 连续数组判断
 * 输入： [1,2,3,6,7,9, 20,22,23]
 * 输出： 1-3, 6-7, 9, 20, 22-23
 */
public class SortedArray {

    public static void main(String[] args) {
        SortedArray sa = new SortedArray();
        int[] a = new int[]{1,2,3,6,7,9,20,22,23};
        sa.solve(a);
    }

    private void solve(int[] array){
        List<String> list = new ArrayList();
        int len = array.length;
        int i = 0 , j = i + 1;
        int last = 0;
        boolean sorted = false;
        while(i < len - 1 ){
            if(array[j] - array[i] == 1){
                if(!sorted) {
                    list.add(array[i] + "");
                    sorted = true;
                }
            }else{
                if(sorted){
                    list.add(list.get(list.size() -1 ) + "-" + array[i]);
                    list.remove(list.get(list.size() -2));
                }else{
                    list.add(array[i] + "");
                }
                sorted = false;
            }
            last = array[i];
            i ++;
            j = i + 1;
        }
        if(array[i] - last == 1){
            list.add(list.get(list.size() -1 ) + "-" + array[i]);
            list.remove(list.get(list.size() -2));
        }else{
            list.add(array[i] + "");
        }
        System.out.println("输出: " + list);
    }

}
