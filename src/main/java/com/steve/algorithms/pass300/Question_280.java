package com.steve.algorithms.pass300;


/**
 * 简单:
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class Question_280 {

    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroFoundAt ++] = nums[i];
            }
        }
        for(int i=lastNonZeroFoundAt; i< nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Question_280 question = new Question_280();
//        int[] src = new int[]{0, 1, 0, 3, 12};
        int[] src = new int[]{0, 0, 1};
        question.moveZeroes(src);
        System.out.println();
    }

}
