package com.steve.hdoj;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 11/5/16.
 * 贪心算法解决猫和老鼠换粮食的问题
 */
public class HDU1009 {

    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Node[] node = null;
        while(m != -1 && n != -1 && m <=1000 && n<=1000){
            node =new Node[n];
            //获取数据
            for(int i=0;i<n;i++){
                //初始化对象数组
                Node no = new Node();
                no.J = sc.nextInt();
                no.F = sc.nextInt();
                no.JF = no.J/no.F;
                node[i] = no;
            }
            //处理数据并返回结果
            DecimalFormat df = new DecimalFormat("0.000");
            double result = fatmouse(node,m,n);
            System.out.println(df.format(result));
            m = sc.nextInt();
            n = sc.nextInt();
        }
    }

    static class Node{
        //每行的左右值
        int J,F;
        //每行的单位cat food of warehouse food
        double JF;
    }
    private static double fatmouse(Node[] no,int m,int n) {
        Arrays.sort(no);
        return 0;
    }
}
