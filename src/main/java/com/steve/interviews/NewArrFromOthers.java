package com.steve.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从两个数组中找寻不相同的元素并组成新数组
 * Created by liu on 1/6/17.
 */
public class NewArrFromOthers<T>{

    public static void main(String... args){
        int[] arr1={1,3,5,7,9},arr2={3,5,6,7,8};
        //翻转移动
        int[] b = move(arr1,1);
        for(int c:b){
            System.out.println(c);
        }
    }

    public static int[] diff(int[] arr1,int[] arr2){
        int index=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int b : arr1){
            list.add(b);
        }
        for(int i = 0;i<arr2.length;i++){
            if(!list.contains(arr2[i]))
                //这里如果使用remove的话list会调用remove(int index)这个方法,导致出现ArrayINdexOutOfBound运行时错误
                list.add(arr2[i]);
        }
        int[] newArr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            newArr[i] = list.get(i);
        }
        return newArr;
    }

    //合并数组方法
    static<T> int[] concact(int[] arr1,int[] arr2){
        int[] a = Arrays.copyOf(arr1,arr1.length+arr2.length);
        System.arraycopy(arr2,0,a,arr1.length,arr2.length);
        return a;
    }

    //将一个数组中的后m个数移动到前m个数 len = 5  m = 2
    static int[] move(int[] origin,int m){
        int len = origin.length,temp;
        for(int i=0;i<m; i++){
            temp = origin[i];
            origin[i] = origin[len-i-1];
            origin[len-i-1] = temp;
        }
        return origin;
    }

}

