package com.steve.hdoj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by liu on 10/28/16.
 */
class TickTick {
    /*
    * The three hands of the clock are rotating every second and meeting each other many times everyday.
    * Finally, they get bored of this and each of them would like to stay away from the other two.
    * A hand is happy if it is at least D degrees from any of the rest. You are to calculate
    * how much time in a day that all the hands are happy.
    *
       *
      * input :The input contains many s cases. Each of them has a single line with
        *   a real number D between 0 and 120, inclusively. The input is terminated with a D of -1.
        *
        *
      *output:For each D, print in a single line the percentage of time in a day that all of the hands are happy,
       *  accurate up to 3 decimal places.
       *
      *example input:
      *     0
      *     120
      *     90
      *     -1

      * example output:
      *     100.000
      *     0.000
      *     6.251
    * */

    /*
    * 解：这个题目需要取共同速度和相对00:00:00时刻的三个角度，然后对区间求解即可 求解时间段
    *   D<=|A_hour - A_min| <=360-D
    *   D<=|A_hour - A_sec| <=360-D
    *   D<=|A_min - A_sec | <=360-D
    * */

    //30°　60min 0.5°/min 60s 1/120°/S

    private static final double V_hour=1.0/120;   //时针角速度(以分为单位) 0.5°/s
    private static final double V_min =0.1;
    private static final double V_sec =6.0;
    private static double degree;
    private static final double s=0.0;
    static class Node{
        double l;                      //left　时间端
        double r;                      //right 时间端
    }
    public static void main(String... args){
        Scanner sc =new Scanner(System.in);
        degree = sc.nextDouble();
        while(degree != -1) {
            double result=0.0;
            //12小时
            for(int h=0;h<12;h++){
                //60分钟
                for(int m=0;m<60;m++){
                    result +=happytime(h,m);
                }
            }
            DecimalFormat df = new DecimalFormat("0.000");
            System.out.println(df.format(result*100.0/43200));
            degree = sc.nextDouble();
        }
    }
     static double happytime(int h,int m){
        double A_hour=30*h+0.5*m+1/120*s;   //verytime angle 　30 * h + 0.5 m + 1/120*s
        double A_min=6*m+0.1*s;             //                 6 * m + 0.1 * s
        double A_sec=6*s;                   //                 6 * s
        //定义一个二维数组,存放6次交集的结果
        Node[][] s0 = new Node[3][2];
        //6个交集的结果
        Node s1;
        //计算交集
        /*
        *   D<=|A_hour - A_min| <=360-D
        *   D<=|A_hour - A_sec| <=360-D
        *   D<=|A_min - A_sec | <=360-D
        * */
        //第一个
        double v_diff=V_hour-V_min;   //角速度差
        double a_diff=A_hour-A_min;   //每时每刻的角度差
        s0[0][0]=canculate(v_diff,a_diff);
        s0[0][1]=canculate(-v_diff,-a_diff);
        //第二个
        v_diff=V_hour-V_sec;
        a_diff=A_hour-A_sec;
        s0[1][0]=canculate(v_diff,a_diff);
        s0[1][1]=canculate(-v_diff,-a_diff);
        //第三个
        v_diff=V_min-V_sec;
        a_diff=A_min-A_sec;
        s0[2][0]=canculate(v_diff,a_diff);
        s0[2][1]=canculate(-v_diff,-a_diff);
        /*
        * 得到６个time区间,对这６个区间取时间交集
        * 　　得到总时间 单位是秒
        * */
        double res=0.0;
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                for(int k=0;k<2;k++) {
                    s1 = jiao(jiao(s0[0][i], s0[1][j]), s0[2][k]);
                    res += s1.r-s1.l;
                }
        return res;
    }
    //计算时间区间　(６个区间求交集)
    //v 角速度差　　a 角度差
    static Node canculate(double v,double a){
        //计算公式: D<=v*t + a <=360*D
        Node p=new Node();
        if(v>0){
            p.l=(degree-a)/v;
            p.r=(360-degree-a)/v;
        }else{
            p.l=(360-degree-a)/v;
            p.r=(degree-a)/v;
        }
        if(p.l<0)p.l=0;
        if(p.r>60)p.r=60;
        if(p.l>=p.r)p.l=p.r=0;
        return p;
    }
    //取两个区间的交集
    static Node jiao(Node l,Node r){
        Node p=new Node();
        p.l=Math.max(l.l,r.l);       //取左端最大值
        p.r=Math.min(l.r,r.r);       //取右端最小值
        if(p.l>=p.r) p.l=p.r=0;
        return p;
    }
}
