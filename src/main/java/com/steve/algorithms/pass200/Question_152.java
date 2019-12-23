package com.steve.algorithms.pass200;

/**
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
public class Question_152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin =1;
        for(int i=0; i <nums.length; i++){
            if(nums[i] < 0 ){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(imax, max);
        }
        return max;
    }
    

    public static void main(String[] args) {
        Question_152 question = new Question_152();

        System.out.println(question.maxProduct(new int[]{2,3,-2,4}));
    }

}
