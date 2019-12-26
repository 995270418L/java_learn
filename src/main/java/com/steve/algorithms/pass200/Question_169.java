package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

/**
 * 简单：
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 *
 *
 */
public class Question_169 {

    public int majorityElement(int[] nums) {
        int last = nums[0];
        int count = 1;
        for(int i=1; i< nums.length; i++){
            if(nums[i] == last) count ++;
            else count --;
            if(count == 0){
                i ++;
                last = nums[i];
                count = 1;
            }
        }
        return last;
    }


    public static void main(String[] args) {
        Question_169 question = new Question_169();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(question.majorityElement(new int[]{1,2,3})); // 701 52
    }

}
