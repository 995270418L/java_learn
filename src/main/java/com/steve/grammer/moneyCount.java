package com.steve.grammer;

/**
 * Created by liu on 3/13/17.
 * 使用钱币的问题,求最少需要多少枚硬币。
 */
public class moneyCount {

    public static int[] money = {1,5,10,50,100,500};

    public static int[] count = {3,2,1,3,0,2};

    static int aim = 620;

    //肯定是从最大值到最小值取
    public static void main(String... args){
        int num = 0,left = aim ;

        for(int i=count.length-1 ; i >= 0 ; i--){
            int t = left/money[i];
            if(t <= count[i]){
                num += t;
                left = left - t * money[i];
            }else{
                num = num + count[i];
                left = left - count[i] * money[i];
            }
        }

        if(left == 0){
            System.out.println(num);
        }else{
            System.out.println("not enough");
        }
    }
}
