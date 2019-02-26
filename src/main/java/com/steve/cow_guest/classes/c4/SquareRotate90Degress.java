package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 19:34 2018/6/17
 * @Description: 正方形矩阵顺时针旋转90度打印数据，比如:
 *
 *  1 2 3                      7 4 1
 *  4 5 6         ======>>>    8 5 2
 *  7 8 9                      9 6 3
 *
 *  思路，也可以画框解决，将每个小正方形位置换好就行了
 * @Modified By:
 */
public class SquareRotate90Degress {

    private static final int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    private static final int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};

    public static void rotateArr(int[][] arr){
        int a = 0 ,b = 0;
        int c = arr.length - 1;
        int d = c;
        while(a < c){
            rotateVarSqure(arr,a++,b,c--,d);
        }
    }

    public static void rotateVarSqure(int[][] arr, int ulr, int ulc, int lrr, int lrc){
        if(ulr == lrr){
            return;
        }else{
            int times = lrr - ulr;
            for(int i=0;i< times;i++){
                int tmp = arr[ulr][ulc+i];
                arr[ulr][ulc+i] = arr[lrr-i][ulc];
                arr[lrr-i][ulc] = arr[lrr][lrc-i];
                arr[lrr][lrc-i] = arr[ulr+i][lrc];
                arr[ulr+i][lrc] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + "\t");
            }
        }
        System.out.println();
        rotateArr(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + "\t");
            }
        }
    }

}
