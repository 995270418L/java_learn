package com.steve.hdoj;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by liu on 10/30/16.
 */
class HDU1007 {

    private static Point[] p;
    private static Point[] py;
    //求最小点对的距离
    //定义点的坐标
    static class Point{
        double x;
        double y;
    }

    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        System.out.println("程序开始!");
        int n = sc.nextInt();
        while(n!=0){
            System.out.println("输入开始!");
            p = new Point[n];
            for(int i=0;i<n;i++){
                Point px =new Point();
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                px.x=x;
                px.y=y;
                p[i] = px ;
            }
            System.out.println("输入结束");
            sort(p,0,p.length-1,"x");
            double result = find(0,n-1)/2;
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(result));
            n=sc.nextInt();
        }
        System.out.println("测试程序结束!");
    }
    //分治求最小值
    public static double find(int l, int r){
        //他们是相邻的两点
        if((l+1)==r){
            return dis(p[l],p[r]);
        }
        //如果中间的点和左边的点的距离最小或者另一种情况的话
        if((l+2)==r){
            return Math.min(dis(p[l],p[r]),Math.min(dis(p[l],p[l+1]),dis(p[l+1],p[r])));
        }
        int mid = (l+r)>>1;
        double ans = Math.min(find(l,mid),find(mid+1,r));
        //找寻比左边界最小值d1和右边界最小值d2还要小点集合，判断标准是这些点的横坐标减去mid的横坐标小于d1和d2中的最小值(ans)。
        //把x坐标在p[mid].x-ans~p[mid].x+ans范围内的点取出来
        int count=0;
        for(int i=l;i<r;i++){
            if(p[i].x>=p[mid].x-ans && p[i].x<p[mid].x+ans){
                py[count++]=p[i];
            }
        }
        sort(py,0,py.length-1,"y");
        for(int i=0;i<count;i++){
            for(int j=i+1;j<count;j++){
                //按y坐标排序
                if(py[j].y-py[i].y>=ans){
                    break;
                }
                ans = Math.min(ans,dis(py[i],py[j]));
            }
        }
        return ans;
    }
    public static double dis(Point a,Point b){
        return Math.sqrt(Math.pow((b.x-a.x),2)+Math.pow((b.y-a.y),2));
    }

    //自制快排排序对象
    public static void sort(Point[] t,int left,int right,String local){
        if(left <right) {
            int i = left;
            int j = right;
            if (local.equals("x")) {
                double x = t[left].x;
                double y = t[left].y;
                while (i < j) {
                    while (i < j && t[j].x >= x) {
                        j--;
                    }
                    if (i < j) {
                        t[i].y = t[j].y;
                        t[i++].x = t[j].x;
                    }
                    while (i < j && t[i].x < x) {
                        i++;
                    }
                    if (i < j) {
                        t[j].y = t[i].y;
                        t[j--].x = t[i].x;
                    }
                }
                t[i].x = x;
                t[i].y = y;
            }
            if (local.equals("y")) {
                double x = t[left].y;
                double y = t[left].x;
                while (i < j) {
                    while (i < j && t[j].y >= x) {
                        j--;
                    }
                    if (i < j) {
                        t[i].x = t[j].x;
                        t[i++].y = t[j].y;
                    }
                    while (i < j && t[i].y < x) {
                        i++;
                    }
                    if (i < j) {
                        t[j].x = t[i].x;
                        t[j--].y = t[i].y;
                    }
                }
                t[j].y = x;
                t[j].x = y;
            }
            sort(t, left, i, local);
            sort(t, i + 1, right, local);
        }
    }

}
