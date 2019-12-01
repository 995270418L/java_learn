package com.steve.algorithms.pass100;


import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class Question_16 {

    /**
     * 排序 + 双指针。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for(int k=0; k < nums.length; k++){
            int i=k+1, j=len -1;
            if(nums[k] > Math.abs(ans))
                break;
            if(k > 0 && nums[k] == nums[k-1])
                continue;
            while(i < j){
                // 判断每次循环的最小值问题，如果最小值要大于 target， 则表示后面所有的值都大于target，这时候只需要判断 结果的靠近程度了。
                int min = nums[k] + nums[i] + nums[i+1];
                if(target < min){
                    if(Math.abs(ans - target) > Math.abs(min - target)){
                        ans = min;
                    }
                    break;
                }
                // 判断每次循环的最大值问题，原理同上
                int max = nums[k] + nums[j-1] + nums[j];
                if(target > max){
                    if(Math.abs(ans - target) > Math.abs(max - target)){
                        ans = max;
                    }
                    break;
                }

                int sum = nums[k] + nums[i] + nums[j];
                int diff = Math.abs(sum - target);
                if(diff < Math.abs(ans - target)){
                    ans = sum;
                }
                if(sum < target) {
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > target)
                    while(i < j && nums[j] == nums[--j]);
                else
                    return sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question_16 q = new Question_16();
        int[] nums = {0, 1, 2};
        int target = 0;
        System.out.println(q.threeSumClosest(nums, target));
    }

}
