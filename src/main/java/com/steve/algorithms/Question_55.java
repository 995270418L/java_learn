package com.steve.algorithms;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 */
public class Question_55 {

    enum Index{
        BAD, GOOD, UNKNOW;
    }

    /**
     * 往最右的方向上想，就是贪心，每次走最大
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums){
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    /**
     * 类似动态规划的思想来解决
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums){
        Index[] memo = new Index[nums.length];
        for(int i=0; i< nums.length; i++){
            memo[i] = Index.UNKNOW;
        }
        memo[nums.length - 1] = Index.GOOD;
        for(int i=nums.length -2; i>=0; i--){
            int nextMaxJump = Math.min(i + nums[i], nums.length - 1);
            for(int j=i+1; j<= nextMaxJump; j++){
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        List<Integer> res = new ArrayList<>();
        backtracking(nums, nums[0], 0, new Stack(), res);
        return !res.isEmpty();
    }

    public void backtracking(int[] nums, int end, int index, Stack<Integer> visited, List<Integer> res){
        if(index == nums.length - 1 && nums[nums.length-1] == end){
            res.add(1);
            return;
        }
        for(int i=1; i<=end && (index+ i) < nums.length; i++){
            visited.push(i);
            backtracking(nums, nums[index + i], index + i, visited, res);
            visited.pop();
        }
    }

    public static void main(String[] args) {
        Question_55 question = new Question_55();
        System.out.println(question.canJump3(new int[]{3,2,1,0,4}));
    }

}
