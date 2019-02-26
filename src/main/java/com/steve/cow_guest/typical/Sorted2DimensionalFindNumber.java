package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 15:59 2018/2/26
 * @Description: 在一个排好序的二维数组里面找指定的数字(行升序排序，列升序排序)，找到就返回true，没找到返回false
 * 解决思路: 从右上角开始找起。
 * @Modified By:
 */
public class Sorted2DimensionalFindNumber {

    public static void main(String[] args) {
        int[][] a = {{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        System.out.println("has find 3 ? " + sorted2DimensionalFindNumber(a,3));
    }

    private static boolean sorted2DimensionalFindNumber(int[][] a,int target) {
        int column = a[0].length;
        for(int i=0;i < a.length ; i++){
            for(int j = column - 1; j >= 0; j--){
                if(a[i][j] == target){
                    return true;
                }
                if(a[i][j] > target){
                    column --;
                    i--;
                    break;
                }
                if(a[i][j] < target){
                    break;
                }
            }
        }
        return false;
    }
}
