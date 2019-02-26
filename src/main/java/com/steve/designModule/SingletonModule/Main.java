package com.steve.designModule.SingletonModule;

import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by liu on 3/26/17.
 */
public class Main {

//    public static void main(String... args){
////        LoadBanlance1 lb1 = LoadBanlance1.getInstance();
////        LoadBanlance1 lb2 = LoadBanlance1.getInstance();
////        LoadBanlance1 lb3 = LoadBanlance1.getInstance();
////        if(lb1 == lb2 && lb2 == lb3 && lb1 == lb3){
////            System.out.println("Sure to Singleton");
////        }
////        LoadBanlance2 lb1 = LoadBanlance2.getInstance();
////        LoadBanlance2 lb2 = LoadBanlance2.getInstance();
////        LoadBanlance2 lb3 = LoadBanlance2.getInstance();
////        if(lb1 == lb2 && lb2 == lb3 && lb1 == lb3){
////            System.out.println("Sure to Singleton");
////        }
//        LoadBanlance3 lb1 = LoadBanlance3.getInstance();
//        LoadBanlance3 lb2 = LoadBanlance3.getInstance();
//        LoadBanlance3 lb3 = LoadBanlance3.getInstance();
//        if(lb1 == lb2 && lb2 == lb3 && lb1 == lb3){
//            System.out.println("Sure to Singleton");
//        }
//
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int[] a = new int[1000];
//            int sum = 0, l = 0, left =0;
//            for(int i=2;i<=n ;i++){
//                a[l++] = i;
//                sum += i;
//                if(sum > n){
//                    sum -= i;
//                    l--;
//                    left = n-sum;
//                    break;
//                }
//            }
//            for(int i=l-1; left > 0;left --){
//                a[i]++ ;
//                i --;
//                if(i<0) i=l-1;
//            }
//            int j = 1;
//            for(int i=0;i<=l-1;i++){
//                j *= a[i];
//            }
//            System.out.println(j);
//        }
//    }

    static int maxProfit(int[] a, int k) {
        int start = a[0], prefix = 0, sum = 0, max= 0;
        for(int i=1;i<a.length;i++){
            if(a[i] > max && max != 0){
                continue;
            }else if(max != 0 && a[i] <= max){
                start = a[i];
                max = 0 ;
                continue;
            }

            if(a[i]<a[i-1] && max == 0){
                prefix = a[i-1] - start;
                sum += prefix;
                max = a[i-1];
                i = i + k - 1;
            }else if((a[i] > a[i-1]) &&  i == a.length-1){
                prefix = a[i] - start;
                sum += prefix;
            }
        }
        return sum;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _stockPrices_size = 0;
        _stockPrices_size = Integer.parseInt(in.nextLine().trim());
        int[] _stockPrices = new int[_stockPrices_size];
        int _stockPrices_item;
        for(int _stockPrices_i = 0; _stockPrices_i < _stockPrices_size; _stockPrices_i++) {
            _stockPrices_item = Integer.parseInt(in.nextLine().trim());
            _stockPrices[_stockPrices_i] = _stockPrices_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = maxProfit(_stockPrices, _k);
        System.out.println(String.valueOf(res));
    }
}
