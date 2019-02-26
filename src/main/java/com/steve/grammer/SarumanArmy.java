package com.steve.grammer;

import java.util.*;

/**
 * Created by liu on 3/14/17.
 * 计算至少需要标记的点(p45)  一直向前!贪心算法
 */
public class SarumanArmy {

    static int n = 6;

    static int[] a = {1,7,15,20,30,40};

    static int r = 10;

    public static void main(String... args){
        List<Integer> list = new ArrayList();   //记录标记的点的总数
        int right;      //与记录标记的点相比较的值
        int tmp;      //开始的数字
        int i = 0;
        //循环每个点位
        while(i < n){
            //覆盖左部分
            right = a[i] + r;    //11
            while( i<n-1 && right >= a[i+1]){    //i: 1 right: 10
                i++;
            }
            tmp = a[i];
            //这里得到的a[i]即标记的点数
            list.add(tmp);  //加入列表
            //找寻下一个循环的开始
            while( i<n-1 && a[i+1] - tmp <= r ) {
                i++;
            }
            if(i<n){
                i++;
            }
        }
        System.out.println(list.size());
    }
}
