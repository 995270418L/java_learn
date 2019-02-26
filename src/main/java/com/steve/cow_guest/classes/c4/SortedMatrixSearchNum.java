package com.steve.cow_guest.classes.c4;

/**
 * @Author: steve
 * @Date: Created in 7:42 2018/6/18
 * @Description: 有序矩阵中找寻指定的数,一个矩阵，每行从小到大排序，每列从小到大排序。找指定的数。返回true or false
 * 思路：这种最优解的方法，一般数据有问题，一般问法有问题。
 * @Modified By:
 */
public class SortedMatrixSearchNum {

    private static final int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

    /**
     * 从右上角开始找寻
     * @param arr
     * @param num
     */
    private static int[] findNum(int[][] arr, int num){
        if(arr.length<=0){
            return null;
        }
        int fr = 0,fc = arr[0].length-1;
        while(fr < arr.length && fc >= 0){
            if(arr[fr][fc] == num){
                return new int[]{fr,fc};
            }else if(arr[fr][fc] > num){
                fc -- ;
            }else{
                fr++;
            }
        }
        return null;
    }

    private static boolean find(int[][] arr,int num){
        int[] result = findNum(arr,num);
        if(result == null){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(find(arr,7));
    }

}
