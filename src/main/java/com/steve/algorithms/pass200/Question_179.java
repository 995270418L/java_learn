package com.steve.algorithms.pass200;

import com.steve.algorithms.base.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 */
public class Question_179 {

    class LargeNumberCompare implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        }
    }
    /**
     * 字符串字典降序排序
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];

        for(int i=0; i< nums.length; i++){
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, new LargeNumberCompare());

        if(numStr[0].equals("0")) return "0";
        String res = "";
        for(String s : numStr){
            res += s;
        }
        return res;
    }

    public static void main(String[] args) {
        Question_179 question = new Question_179();
        System.out.println(question.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

}
