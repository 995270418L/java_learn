package com.steve.algorithms.pass300;


import com.steve.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 */
public class Question_229 {

    /**
     *  1 1 1 2 3 4  2
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length <= 0) return res;
        int numA = nums[0], numB = nums[0];
        int countA = 0, countB = 0;
        for(int num : nums){
            if(num == numA){
                countA ++;
                continue;
            }else if(num == numB){
                countB ++;
                continue;
            }

            if(countA == 0){
                numA = num;
                countA ++;
                continue;
            }else if(countB == 0){
                numB = num;
                countB ++;
                continue;
            }
            countA --;
            countB --;
        }
        countA = 0;
        countB = 0;
        for(int num : nums){
            if(num == numA){
                countA ++;
            }else if(num == numB){
                countB ++;
            }
        }
        if(countA >= nums.length / 3) res.add(numA);
        if(countB >= nums.length / 3) res.add(numB);
        return res;
    }

    public static void main(String[] args) {
        Question_229 question = new Question_229();
        System.out.println(question.majorityElement(new int[]{2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9}));
    }

}
