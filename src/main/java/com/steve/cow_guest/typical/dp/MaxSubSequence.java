package com.steve.cow_guest.typical.dp;

/**
 * @Author: steve
 * @Date: Created in 9:50 2018/3/6
 * @Description: 最长递增子序列长度
 * @Modified By:
 */
public class MaxSubSequence {

    public static void main(String[] args) {
        int[] source = {2,1,5,3,6,4,8,9,7};
        int dp[] = new int[source.length];
        System.out.println("最长的递增子序列长度为: " + dpm(source,dp));
    }

    private static int dpm(int[] source, int[] dp) {
        dp[0] = 1;
        for(int i = 1; i< source.length; i++){
            int maxOfSourceSub = Integer.MIN_VALUE,index = Integer.MIN_VALUE;
            // 得到最大值
            for(int j = i-1; j>=0 ;j--){
                if(source[i] > source[j] && source[j] > maxOfSourceSub){
                    maxOfSourceSub = source[j];
                    index = j;
                }
            }
            if(index == Integer.MIN_VALUE){
                dp[i] = 1;
            }else{
                dp[i] = dp[index] + 1;
            }
        }
        // 返回最大值
        int result = 0;
        for(int i = 0;i < dp.length; i++){
            if(dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }
}
