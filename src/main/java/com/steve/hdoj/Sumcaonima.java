package com.steve.hdoj;

import java.math.BigDecimal;
import java.util.Scanner;

public class Sumcaonima {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int times = sc.nextInt();
        String numbers = sc.nextLine();
        if(times>=1 && times <=20) {
            for (int i = 1; i <= times; i++) {
                String numbers2 = sc.nextLine();
                BigDecimal bd1 = new BigDecimal(numbers2.split(" ")[0]);
                BigDecimal bd2 = new BigDecimal(numbers2.split(" ")[1]);
                BigDecimal bd3 = bd1.add(bd2);
                System.out.println("Case " + i + ":");
                System.out.println(bd1.toString() + "  " + "+" + "  " + bd2.toString() + "  " + "=" + "  " + bd3.toString());
                System.out.println();
            }
        }
    }
}

class maxSub{

    public static void main(String... args){

        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        String blankLine = sc.nextLine();
        for(int i=1;i<=times;i++){
            String numbers = sc.nextLine();
            System.out.println(numbers);
            String[] a = numbers.split(" ");
            int[] b = new int[a.length];
            for(int j=0;j<b.length;j++){
                b[j] = Integer.valueOf(a[j]);
            }
            int maxSum = 0;
            int start = 0, end = 0;
            //[6,-1,5,4,-7]
            for(int k=0;k<b.length;k++){

                int thisSum = 0;

                for(int l = k; l< b.length; l++){
                    thisSum += b[l];
                    start = k+1;
                    if(maxSum < thisSum){
                        maxSum = thisSum;
                        end = l+1;
                    }
                }
            }
            System.out.println(maxSum + " " + start +" "+ end);
        }
    }

}