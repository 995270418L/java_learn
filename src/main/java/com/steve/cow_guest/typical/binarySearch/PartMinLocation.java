package com.steve.cow_guest.typical.binarySearch;

/**
 * @Author: steve
 * @Date: Created in 14:45 2018/2/28
 * @Description: 无序arr数组，返回它的任意一个局部最小值的位置，
 *      当 arr[0] < arr[1] 时，0位置即为局部最小值的位置。
 *      当 arr[N-1] < arr[N-2] 时，N-1位置即为局部最小值的位置(数组最后一个元素)。
 *      当 arr[k-1] < arr[k] < arr[k+1] 时，k位置即为局部最小值的位置
 * 解决:
 *      大部分情况下可以用二分搜索法完成，只有当arr[0] == arr[m] == arr[N-1] 时需要遍历整个数组
 *
 * @Modified By:
 */
public class PartMinLocation {

    public static void main(String[] args) {
        int[] source = {6,4,3,1,2,4,5,6,7,8};
        int result = partMinLocation(source);
        System.out.println("局部最小值的位置(数组下标): " + result);
    }

    private static int partMinLocation(int[] source) {
        if(source == null ){
            return -1;
        }
        if(source.length == 1){
            return 0;
        }

        if(source[0] < source[1]){
            return 0;
        }

        if(source[source.length - 1] < source[source.length - 2]){
            return source.length - 1;
        }

        return findMin(source,0,source.length-1);
    }

    /**
     * 二分法的右边界也是可以访问到的
     * @param source
     * @param left
     * @param right
     * @return
     */
    private static int findMin(int[] source, int left, int right) {
        int r = (right + left) / 2;
        if(source[left] == source[r] && source[r] == source[right]){
            return goThrough(source,left,right-1);
        }
        if(source[r] < source[r + 1] && source[r] < source[r-1]){
            return r;
        }else if(source[r] > source[r -1]){
            return findMin(source,left,r);
        }else if(source[r] > source[r+1]){
            return findMin(source,r,right);
        }
        return -1;
    }

    /**
     * 开区间 [start,end]
     * @param source
     * @param start
     * @param end
     * @return
     */
    private static int goThrough(int[] source, int start, int end) {
        for(int i=start+1;i < end; i++){
            if(source[i] < source[i-1] && source[i] < source[i+1]){
                return i;
            }
        }
        return -1;
    }

}
