package com.steve.cow_guest.typical.dp;

/**
 * @Author: steve
 * @Date: Created in 17:46 2018/3/5
 * @Description: 走矩阵，只能向右或者向下走。问走过的最小路径和
 * @Modified By:
 */
public class PathMinimum {

    public static void main(String[] args) {
        int[][] source = {
                {1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,2}
        };
        int m = 4, n = 4;
        int[][] result = new int[4][4]; // result[i][j] 表示走到位置[i][j]的最小路径和
        System.out.println("最小路径和: " + dpm(source,result));
    }

    private static int dpm(int[][] source, int[][] result) {
        for(int i=0; i<source.length; i++){
            if(i == 0){
                result[i][0] = source[i][0];
            }else {
                result[i][0] = result[i-1][0] + source[i][0];
            }
            for(int j =1; j< source[0].length; j++){
                if(i == 0){
                    result[i][j] = result[i][j-1] + source[i][j];
                }else{
                    result[i][j] = Math.min(result[i-1][j],result[i][j-1]) + source[i][j];
                }
            }
        }
        return result[3][3];
    }
}
