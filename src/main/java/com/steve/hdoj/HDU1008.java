package com.steve.hdoj;

import java.util.Scanner;

/**
 * Created by liu on 11/2/16.
 *   电梯队列问题
 */
class HDU1008 {

    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while( n != 0){
            int[] a = new int[n];
            int sum = 0,wait = 0;
            if(n == 1){
                a[0] = sc.nextInt();
                System.out.println(a[0]*6+5);
                n = sc.nextInt();
                continue;
            }
            else{
                for(int i=0;i<n;i++){
                    a[i] = sc.nextInt();
                }
                wait = n *5;
                sum = a[0]*6;
                for(int j = 1;j<n;j++){
                    if(a[j]>a[j-1]){
                        //后面的数字比前一个大　上楼
                        sum = sum + (a[j]-a[j-1]) *6;
                    }else if(a[j]<a[j-1]){
                        //小 下楼
                        sum = sum + (a[j-1]-a[j])*4;
                    }
                    else{
                        //相等　什么都不做
                    }
                }
                sum = sum + wait;
            }
            System.out.println(sum);
            n = sc.nextInt();
        }

    }

}
