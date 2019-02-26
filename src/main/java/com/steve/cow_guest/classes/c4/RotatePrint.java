package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 19:03 2018/6/17
 * @Description: 旋转打印矩阵，比如:
 * 1  2  3  4
 * 5  6  7  8     ======>>>   1 2 3 4 8 12 11 10 9 5 6 7
 * 9 10 11 12
 *
 * 思路： 两个坐标四个点(a,b)(c,d)，每次打印四条边的数据，这样连起来就解决问题了
 * @Modified By:
 */
public class RotatePrint {

    private static final int[][] ARR = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

    public static void rotateMatrix(int[][] arr){
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while(a <= c && b <= d){
            printEdge(arr,a++,b++,c--,d--);
        }
    }
    /**
     *
     * @param arr 二维数组
     * @param ulr 左上角x坐标
     * @param ulc 左上角y坐标
     * @param lrr 右下角x坐标
     * @param lrc 右下角y坐标
     */
    public static void printEdge(int[][] arr,int ulr,int ulc,int lrr,int lrc){
        // 横线
        if(ulr == lrr){
            for(int i=ulc; i<= lrc; i++){
                System.out.print(arr[ulr][i] + "\t");
            }
        // 竖线
        }else if(ulc == lrc){
            for(int i = ulr; i<= lrr; i++){
                System.out.print(arr[i][ulc] + "\t");
            }
        }else{
            // 方框
            int x = ulr;  // 起始x坐标
            int y = ulc;  // 起始y坐标
            while(y != lrc){
                System.out.print(arr[ulr][y++] + "\t");
            }
            while(x != lrr){
                System.out.print(arr[x++][lrc] + "\t");
            }
            while(y != ulc){
                System.out.print(arr[lrr][y--] + "\t");
            }
            while (x != ulr){
                System.out.print(arr[x--][ulc] + "\t");
            }
        }
    }

    public static void main(String[] args) {
        rotateMatrix(ARR);
    }
}
