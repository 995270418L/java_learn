package com.steve.algorithms.pass300;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 */
public class Question_260 {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.get(num) == null){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        int[] res = new int[2];
        int i=0;
        for(int num : nums){
            if(map.get(num) == 1){
                res[i++] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question_260 question = new Question_260();
        int[] res = question.singleNumber(new int[]{1,2,1,3,2,5});
        System.out.println(res);
    }

}
