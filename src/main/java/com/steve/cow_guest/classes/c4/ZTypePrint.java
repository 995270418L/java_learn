package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 20:24 2018/6/17
 * @Description: 之字形打印，将一个矩阵按照之字形打印，如下:
 *  1 2 3 4
 *  5 6 7 8                =====>  1 2 5 6 3 4 7 8
 *
 *  思路: 两个点 A(a,b) 和 B(c,d). 开始A和B都在左上角的点，
 *  A每次往右走，走到边缘后往下走，B 每次往下走，走到最底部了往右走，最终A和B相遇在对角线另一点 。 途中每次走的过程都是一条斜线，就是之字形了。
 * @Modified By:
 */
public class ZTypePrint {

    private static final int[][] arr = {{1,2,3,4},{5,6,7,8}};
    /**
     * 打印斜线
     * @param arr
     * @param ax      A点的x坐标
     * @param ay      A点的y坐标
     * @param bx      B点的x坐标
     * @param by      B点的y坐标
     * @param aFirstB 斜线的打印顺序
     */
    private static void printPoint(int[][] arr, int ax, int ay, int bx, int by,boolean aFirstB){
        if(aFirstB){
            while(ax <= bx){
                System.out.print(arr[ax++][ay--] + "\t");
            }
        }else{
            while(by <= ay){
                System.out.print(arr[bx--][by++] + "\t");
            }
        }
    }

    /**
     * 规划A和B两点走的路线，必须保证两点连线为斜线，而且B点走在A点前
     * @param arr
     */
    public static void planRoute(int[][] arr){
        int ax = 0,ay = 0,bx=0,by = 0;
        int endR = arr.length - 1;
        int endC = arr[0].length -1 ;
        boolean aFirstB = false;
        while (ax != endR+1){
            printPoint(arr,ax,ay,bx,by,aFirstB);
            ax = ay == endC ? ax + 1 : ax;
            ay = ay == endC ? ay: ay+ 1;
            by = bx == endR ? by + 1: by;
            bx = bx == endR ? bx : bx + 1;
            aFirstB = !aFirstB;
        }
    }

    public static void main(String[] args) {
        planRoute(arr);
    }
}
