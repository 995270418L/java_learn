package com.steve.algorithms.pass200;

import com.steve.algorithms.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单：
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
 *
 */
public class Question_167 {

    /**
     * 暴力法，效率极低
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0; i< numbers.length; i++){
            if(numbers[i] > target) break;
            int diff = target - numbers[i];
            for(int j=i+1; j< numbers.length; j++){
                if(numbers[j] > diff) break;
                if(numbers[i] + numbers[j] == target){
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int head=0, last=numbers.length - 1;
        while (head < last){
            int sum = numbers[head] + numbers[last];
            if(sum == target){
                res[0] = head + 1;
                res[1] = last + 1;
                break;
            }else if(sum < target){
                head ++;
            }else {
                last --;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Question_167 question = new Question_167();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(question.twoSum(new int[]{-3,3,4,90},0));
    }

}
