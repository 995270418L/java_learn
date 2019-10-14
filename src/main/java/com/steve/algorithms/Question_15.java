package com.steve.algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class Question_15 {

    /**
     * 双指针法: 时间复杂度 O(n^2), 空间复杂度 O(1). 指针使用常数大小的额外空间
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);  // -4 -1 -1 0 1 2
        int len = nums.length;
        List<List<Integer>> res = new ArrayList();
        for(int k=0; k< len; k++){
            if(nums[k] > 0 )
                break;
            if(k > 0 && nums[k-1] == nums[k]) { // 如果遇到的数字和前面的数字一样，忽略这个数字
                continue;
            }
            int i=k+1, j = len-1;
            while(i < j){   // 这里最多遍历n个元素大小，所以时间复杂度是O(n)
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0)
                    while( i < j && nums[i] == nums[++i]);
                else if(sum > 0)
                    while(i < j && nums[j] == nums[--j]);
                else{
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question_15 q = new Question_15();
        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(q.threeSum(nums));
    }

}
