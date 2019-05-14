package com.steve.leetcode;

/**
 *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] a = {1,3}, b = {2};
        System.out.println(solve(a,b));
    }
    /**
     * 求 m，n 数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double solve(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2= temp;
            int tmp = m; m = n ;n = tmp;
        }
        int iMax = m, iMin=0, hLen = (m + n + 1) / 2;
        while(iMin <= iMax){
            int i = ( iMax + iMin ) / 2;
            int j = hLen - i;
            if(i < m && nums2[j - 1] > nums1[i]){  // i < m ==> j> 0
                iMin = i + 1;
            }else if(i > 0 && nums1[i - 1] > nums2[j]){
                iMax = i - 1;
            }else{
                // i 满足条件

                int maxLeft = 0;
                if( i == 0 ){
                    maxLeft = nums2[j - 1];
                }else if( j == 0 ){
                    maxLeft = nums1[i - 1];
                }else{
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                // 如果 m + n 是奇数, 返回 maxLeft ??
                if((m + n) % 2 == 1) return maxLeft;

                int minRight = 0;
                if( j == n ){
                    minRight = nums1[i];
                }else if(i == m){
                    minRight = nums2[j];
                }else{
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
