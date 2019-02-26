package com.steve.grammer;

import java.util.Scanner;

/**
 * 好多鱼
 * Created by liu on 3/12/17.
 */
public class Perimeter {

    public static Scanner sc = null;

    public static void main(String... args){
        sc = new Scanner(System.in);
        //获取三行数据,第一行为放入鱼的大小范围(包含边界),第二行为原来的鱼的数量，第三行为原来鱼的大小. 1~1000 ,输出鱼的大小的可能性

        //测试数据的输入和处理
        String scope = sc.nextLine();  //以空格分开
        String[] scope_string = scope.split(" ");
        int[] scope_int = new int[scope_string.length];
        for(int i=0;i<scope_string.length;i++){
            scope_int[i] = Integer.parseInt(scope_string[i]);
        }
        int count =  sc.nextInt();
        int[] size = new int[count];
        for(int i=0; i< count ;i++) {
            size[i] = sc.nextInt();
        }
        int a = cal(scope_int,count,size);
    }

    //计算所有鱼的大小可能性
    public static int cal(int[] scope,int count,int[] size){
        for(int i = 0; i<size.length; i++){
            int diff = scope[1] - scope[0];  //放入鱼的范围

            //计算每一条鱼的生存范围
            int min = size[i]*2;     //最小边界(小于就安全)
            int max = size[i]*10;    //最大边界(大于就安全)

            //检测是否越界
            int checkMaxDiff = scope[1] - max;
            int checkMinDiff = scope[0] - min;

            //修改危险鱼的范围
            if(checkMaxDiff > 0 && checkMinDiff < 0){
                //危险范围不变
            }else if(checkMaxDiff < 0 && checkMinDiff > 0){
                //放啥鱼都危险
                return 0;
            }else if(checkMaxDiff < 0 && checkMinDiff < 0){
                max = scope[1];
            }else if(checkMaxDiff > 0 && checkMinDiff > 0){
                min = scope[0];
            }

            //将所有鱼的危险范围集中处理(去重)

        }
        return 0;
    }
}
