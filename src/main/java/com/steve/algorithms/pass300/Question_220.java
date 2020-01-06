package com.steve.algorithms.pass300;

import java.util.TreeSet;

/**
 *
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 */
public class Question_220 {

    /**
     * 滑动窗口 超时
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0; i<nums.length; i++){
            for(int j=Math.max(i - k, 0); j < i; j++){
                if(Math.abs(nums[j] - nums[i]) <= t) return true;
            }
        }
        return false;
    }

    /**
     * 二叉搜索树 43.9 效率也挺低的，毕竟需要维护一颗自平衡二叉搜索树
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i< nums.length; i++){
            // 大于或者等于当前元素的 最近的右元素
            Integer bs = set.ceiling(nums[i]);
            if(bs != null && bs <= t + nums[i]) return true;
            Integer lt = set.floor(nums[i]);
            if(lt != null && nums[i] <= lt + t) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 桶排序思想 (正解)
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        return false;
    }

    public static void main(String[] args) {
        Question_220 question = new Question_220();
//        System.out.println(question.containsNearbyAlmostDuplicate2(new int[]{1,5,9,1,5,9},2, 3));
        System.out.println(question.containsNearbyAlmostDuplicate2(new int[]{-1,2147483647},1, 2147483647));
    }

}
