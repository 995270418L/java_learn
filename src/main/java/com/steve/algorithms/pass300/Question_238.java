package com.steve.algorithms.pass300;


/**
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */
public class Question_238 {

    /**
     * 左右乘积列表
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        L[0] = 1;
        int[] R = new int[n];
        R[n-1] = 1;
        for(int i=1; i<n; i++){
            L[i] = L[i-1] * nums[i-1];
        }
        for(int i=n-2; i>=0 ;i --){
            R[i] = R[i+1] * nums[i+1];
        }
        int[] res = new int[n];
        for(int i=0; i< n;i ++){
            res[i] = L[i] * R[i];
        }
        return res;
    }

    /**
     * Plus 版本
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i< n; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int R = 1;
        for(int i=n-1; i>=0; i--){
            res[i] = R * res[i];
            R = R * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Question_238 question = new Question_238();
        int[] res = question.productExceptSelf2(new int[]{1,2,3,4});
        for(int r : res){
            System.out.println(r);
        }
    }

}
