package com.steve.cow_guest.typical;

/**
 * @Author: steve
 * @Date: Created in 16:16 2018/2/26
 * @Description: 从一个数组中找寻需要排序的最短子数组长度，比如[1,5,4,3,2,6,7]的最短子数组长度为4,即[5,4,3,2]
 *  这个问题的最优解需要遍历两次:
 *  先从左边开始遍历，假设每一个数都可以是最大值，只需记录遍历过的数比最大值小的情况，因为最终的最大值中时会停留在这个记录的当前位置或者他的右边
 *  再从右边开始遍历，假设每一个数都可以是最小值，记录比最小值大的情况,那么最终的最小值总会在记录的值的左边或者记录值的位置。
 * @Modified By:
 */
public class FindShortestArray {

    public static void main(String[] args) {
        int [] source = {1,5,4,3,2,6,7};
        System.out.println("最短子数组长度为: " + getMinSortLength(source,11));
    }

    private static int findShortestArray(int[] source) {
        int max = source[0],min = source[source.length-1],right=0,left=0;
        for(int i=1; i<source.length; i++){
            if(source[i] >= max){
                max = source[i];
            }else{
                // 记录遍历过的比最大值小的数的坐标
                right = i;
            }
        }
        for(int i = source.length - 2; i >= 0; i--){
            if(source[i] <= min){
                min = source[i];
            }else{
                left = i;
            }
        }
        return right - left + 1;

    }

    static int getMinSortLength(int[] arr, int len) {
        if(len == 0) {
            return 0;
        }
        int a = 1;
        while(a < len && arr[a] >= arr[a - 1]) {
            ++a;
        }
        if(a == len){ return 0;}
        int mi = 0x7fffffff;
        for(int i = a; i < len; ++i){
            if(arr[i] < mi){
                mi = arr[i];
            }
        }
        while(a > 0 && arr[a - 1] > mi){
            --a;
        }
        int b = len - 1;
        while(b > 0 && arr[b - 1] <= arr[b]){
            --b;
        }
        int mx = 0x80000000;
        for(int i = 0; i < b; ++i){
            if(arr[i] > mx){
                mx = arr[i];
            }
        }
        while(b < len && arr[b] < mx){
            ++b;
        }
        return b - a;
    }
}
