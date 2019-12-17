package com.steve.algorithms.pass200;

/**
 * 简单：
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 */
public class Question_136 {

    /**
     * XOR 实现
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i =0; i<nums.length; i++){
            a ^= nums[i]; // 相同的两个数字 xor 为0， 0与人任意单个数字 xor 为任意数， xor 支持交换律
        }
        return a;
    }

    public static void main(String[] args) {
        Question_136 question = new Question_136();
        char[][] src = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(question.singleNumber(new int[]{1,2,3,4,5}));
    }

}
